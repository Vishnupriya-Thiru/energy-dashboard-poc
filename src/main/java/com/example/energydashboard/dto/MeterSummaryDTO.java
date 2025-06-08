package com.example.energydashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeterSummaryDTO {
    private Long meterId;
    private String serialNumber;
    private double totalConsumption;
    private long alertCount;
    private double averageConsumption;
}
