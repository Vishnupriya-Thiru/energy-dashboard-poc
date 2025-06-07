package com.example.energydashboard.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.energydashboard.model.Alert;
import com.example.energydashboard.repository.AlertRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/alerts")
@RequiredArgsConstructor
public class AlertController {
	 private final AlertRepository alertRepo;

	    @GetMapping
	    public List<Alert> getAll() {
	        return alertRepo.findAll();
	    }

	    @GetMapping("/meter/{meterId}")
	    public List<Alert> getByMeter(@PathVariable Long meterId) {
	        return alertRepo.findByMeterId(meterId);
	    }
}
