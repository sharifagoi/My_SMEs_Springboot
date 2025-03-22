package com.application.smesbackend.mapper;

import com.application.smesbackend.dto.ProductDto;
import com.application.smesbackend.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDto toDto(Product product) {
        if (product == null) {
            return null;
        }
        return new ProductDto(
            product.getId(),
            product.getName(),
            product.getPrice(), // No conversion needed
            product.getExpiryDate()
        );
    }

    public Product toEntity(ProductDto productDto) {
        if (productDto == null) {
            return null;
        }
        return new Product(
            productDto.getId(),
            productDto.getName(),
            productDto.getPrice(), // No conversion needed
            productDto.getExpiryDate()
        );
    }
}
