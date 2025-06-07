package com.example.energydashboard.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.energydashboard.model.EnergyReading;
import com.example.energydashboard.model.Meter;
import com.example.energydashboard.repository.MeterRepository;
import com.example.energydashboard.repository.ReadingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReadingSimulatorService {
	private final MeterRepository meterrepo;
private final ReadingService readservice;
	
	 @Scheduled(fixedRate = 60000) // Every 60 seconds
	    public void generateReadings() {
	        List<Meter> meters = meterrepo.findAll();

	        for (Meter meter : meters) {
	            EnergyReading reading = new EnergyReading();
	            reading.setMeter(meter);
	            reading.setTimestamp(LocalDateTime.now());

	            // Simulate random kWh between 0.5 and 7.5
	            double consumption = 0.5 + Math.random() * 7.0;
	            reading.setConsumptionInKWH(consumption);

	            readservice.save(meter.getId(),reading);
	        }

	        System.out.println("Simulated readings generated at " + LocalDateTime.now());
	        
	    }
	
}
