package com.example.energydashboard.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.energydashboard.dto.MeterSummaryDTO;
import com.example.energydashboard.model.Meter;
import com.example.energydashboard.service.MeterService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/meters")
@RequiredArgsConstructor
public class MeterController {

	private final MeterService meterservice;
	
	@PostMapping
	public Meter create(@RequestBody Meter meter)
	{ 
		return meterservice.create(meter);
	}
	
	@GetMapping
	public List<Meter> getAllMeters()
	{
		return meterservice.getAllMeters();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Meter> getById(@PathVariable Long id) {
        return meterservice.getMeterById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Meter> update(@PathVariable Long id, @RequestBody Meter updatedmeter)
	{
	  return meterservice.getMeterById(id)
			  .map(meter->{
			  meter.setSerialNumber(updatedmeter.getSerialNumber());
			  meter.setLocation(updatedmeter.getLocation());
			  return ResponseEntity.ok(meterservice.create(meter));
			  }
		)
			  .orElse(ResponseEntity.notFound().build());		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		meterservice.delete(id);
        return ResponseEntity.noContent().build();
    }
	@GetMapping("/summary")
	public List<MeterSummaryDTO> getSummary() {
	    return meterservice.getMeterSummaries();
	}
	
}
