package com.example.energydashboard.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.energydashboard.model.EnergyReading;
import com.example.energydashboard.model.Meter;
import com.example.energydashboard.repository.MeterRepository;
import com.example.energydashboard.repository.ReadingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReadingService {

private final ReadingRepository readingrepo;
private final MeterRepository meterrepo;

	public EnergyReading save(Long meterid, EnergyReading reading) {
		// TODO Auto-generated method stub
		Meter meter=meterrepo.findById(meterid).orElseThrow(()-> new RuntimeException ("Meter not found"));
		reading.setMeter(meter);
		return readingrepo.save(reading);
	}

	public List<EnergyReading> getAllReadings() {
		// TODO Auto-generated method stub
		return readingrepo.findAll();
	}

	public  List<EnergyReading>  getByMeter(Long meterId) {
		// TODO Auto-generated method stub
		return readingrepo.findByMeterId(meterId);
	}


}
