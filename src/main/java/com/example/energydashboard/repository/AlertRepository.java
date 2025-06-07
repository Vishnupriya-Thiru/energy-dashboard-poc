package com.example.energydashboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.energydashboard.model.Alert;

@Repository
public interface AlertRepository  extends JpaRepository<Alert,Long>{
	  List<Alert> findByMeterId(Long meterId);
}
