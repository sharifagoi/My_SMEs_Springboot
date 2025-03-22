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

public class ProductDto {
    private Long id;
    private String name;
    private Double price;
    private String expiryDate;
    
}
