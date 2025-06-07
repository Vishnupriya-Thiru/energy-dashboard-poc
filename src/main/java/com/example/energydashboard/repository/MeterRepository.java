package com.example.energydashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.energydashboard.model.Meter;

@Repository
public interface MeterRepository extends JpaRepository<Meter,Long> {

}
