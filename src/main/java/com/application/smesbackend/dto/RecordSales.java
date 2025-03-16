package com.application.smesbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecordSales {
    private Long id;
    private String name;
    private String quantity;
    private String price;
    private String total;
    private String date;
    
}
