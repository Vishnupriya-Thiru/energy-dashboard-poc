package com.example.energydashboard.model;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meter {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	@NotNull
	 private String serialNumber;
	@NotNull
	 private String location;
}
