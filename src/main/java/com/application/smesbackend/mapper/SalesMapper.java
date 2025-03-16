package com.application.smesbackend.mapper;

import com.application.smesbackend.dto.SalesDto;
import com.application.smesbackend.entity.Sales;
import org.springframework.stereotype.Component;

@Component
public class SalesMapper {

    public SalesDto toDto(Sales sales) {
        return new SalesDto(
                sales.getId(),
                sales.getName(),
                sales.getQuantity(),
                sales.getPrice(),
                sales.getTotal(),
                sales.getDate(),
                sales.getType() // Added type attribute
        );
    }

    public Sales toEntity(SalesDto salesDto) {
        return new Sales(
                salesDto.getId(),
                salesDto.getName(),
                salesDto.getQuantity(),
                salesDto.getPrice(),
                salesDto.getTotal(),
                salesDto.getDate(),
                salesDto.getType() // Added type attribute
        );
    }
}