package com.application.smesbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesDto {
    private Long id;
    private String name;
    private String quantity;
    private String price;
    private String total;
    private String date;
    private String type; // Added type attribute
}