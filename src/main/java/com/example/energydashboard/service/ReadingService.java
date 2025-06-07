package com.example.energydashboard.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.energydashboard.model.Alert;
import com.example.energydashboard.model.EnergyReading;
import com.example.energydashboard.model.Meter;
import com.example.energydashboard.repository.AlertRepository;
import com.example.energydashboard.repository.MeterRepository;
import com.example.energydashboard.repository.ReadingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReadingService {

private final ReadingRepository readingrepo;
private final MeterRepository meterrepo;
private final AlertRepository alertrepo;

	public EnergyReading save(Long meterid, EnergyReading reading) {
		// TODO Auto-generated method stub
		Meter meter=meterrepo.findById(meterid).orElseThrow(()-> new RuntimeException ("Meter not found"));
		reading.setMeter(meter);
		EnergyReading savedreading=readingrepo.save(reading);
		if (savedreading.getConsumptionInKWH() > 5.0) {
		    Alert alert = new Alert();
		    alert.setTimestamp(LocalDateTime.now());
		    alert.setMessage("High consumption: " + savedreading.getConsumptionInKWH() + " kWh");
		    alert.setMeter(meter);
		    alertrepo.save(alert);
		}
		return savedreading;
	
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
