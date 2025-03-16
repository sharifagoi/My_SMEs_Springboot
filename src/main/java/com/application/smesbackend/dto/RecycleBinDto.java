package com.application.smesbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecycleBinDto {
    private Long id;
    private String itemType;
    private String itemId;
    private String itemName;
}