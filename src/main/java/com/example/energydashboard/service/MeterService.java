package com.example.energydashboard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.energydashboard.model.Meter;
import com.example.energydashboard.repository.MeterRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MeterService {
 
	private final MeterRepository repo;
	
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

}
