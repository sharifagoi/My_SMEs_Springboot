package com.application.smesbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class StockDto {
    private Long id;
    private String name;
    private String price;
    private String quantity;
    private String date;
    
}
