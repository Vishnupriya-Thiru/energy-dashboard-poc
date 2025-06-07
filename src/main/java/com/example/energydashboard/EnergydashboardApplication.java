package com.example.energydashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EnergydashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnergydashboardApplication.class, args);
	}

}
