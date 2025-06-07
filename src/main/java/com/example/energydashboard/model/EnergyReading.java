package com.example.energydashboard.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnergyReading {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long energyreadingid;
private LocalDateTime timestamp;
private Double consumptionInKWH;
@ManyToOne
private Meter meter;
}
