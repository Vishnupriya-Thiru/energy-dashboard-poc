package com.example.energydashboard.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.energydashboard.dto.MeterSummaryDTO;
import com.example.energydashboard.model.Alert;
import com.example.energydashboard.model.EnergyReading;
import com.example.energydashboard.model.Meter;
import com.example.energydashboard.repository.AlertRepository;
import com.example.energydashboard.repository.MeterRepository;
import com.example.energydashboard.repository.ReadingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MeterService {
 
	private final MeterRepository repo;
	private final ReadingRepository readingrepo;
	private final AlertRepository alertrepo;
	
	public Meter create(Meter meter) {
		// TODO Auto-generated method stub
		return repo.save(meter);
	}

	public List<Meter> getAllMeters() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Optional<Meter> getMeterById(Long mid) {
		// TODO Auto-generated method stub
		return repo.findById(mid);
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
	public List<MeterSummaryDTO> getMeterSummaries() {
	List<Meter> meters=getAllMeters();
	List<MeterSummaryDTO> summaries=new ArrayList<>();
	
	for(Meter meter:meters)
	{
		List<EnergyReading> reading=readingrepo.findByMeterId(meter.getId());
		List<Alert> alert=alertrepo.findByMeterId(meter.getId());
		Double total=reading.stream().mapToDouble(EnergyReading::getConsumptionInKWH).sum();
		double average=reading.isEmpty()?0.0:total/reading.size();
		 summaries.add(new MeterSummaryDTO(
		            meter.getId(),
		            meter.getSerialNumber(),
		            total,
		            alert.size(),
		            average
		        ));
		    }

		    return summaries;
	}
		

}
