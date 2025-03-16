package com.application.smesbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailySalesDto {
    private String date;
    private Long totalQuantity;
    private Double totalSales;
}