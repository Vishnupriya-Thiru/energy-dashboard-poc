package com.example.energydashboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.energydashboard.model.EnergyReading;


@Repository
public interface ReadingRepository extends JpaRepository<EnergyReading,Long> {

    List<EnergyReading> findByMeterId(Long meterId);
}
