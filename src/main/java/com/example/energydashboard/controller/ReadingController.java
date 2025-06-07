package com.example.energydashboard.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.energydashboard.model.EnergyReading;
import com.example.energydashboard.service.ReadingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/readings")
@RequiredArgsConstructor
public class ReadingController {
private final ReadingService readservice;

@PostMapping("/{meterid}")
public ResponseEntity<EnergyReading> create(@PathVariable Long meterid,@RequestBody EnergyReading reading)
{

return ResponseEntity.ok(readservice.save(meterid,reading)); 
	
}

@GetMapping()
public ResponseEntity<List<EnergyReading>> getAllReadings()
{
	return new ResponseEntity<>(readservice.getAllReadings(),HttpStatus.FOUND);
}

@GetMapping("/meter/{meterId}")
public ResponseEntity<List<EnergyReading>> getByMeter(@PathVariable Long meterId)
{

	return new ResponseEntity<>(readservice.getByMeter(meterId),HttpStatus.FOUND);
}
}
