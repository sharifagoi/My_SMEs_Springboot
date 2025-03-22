package com.application.smesbackend.service.impl;

import com.application.smesbackend.dto.ProductDto;
import com.application.smesbackend.entity.Product;
import com.application.smesbackend.mapper.ProductMapper;
import com.application.smesbackend.repository.ProductRepository;
import com.application.smesbackend.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }

    @Override
    public ProductDto getProductById(Long id) {
        return productRepository.findById(id)
            .map(productMapper::toDto)
            .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
            .map(productMapper::toDto)
            .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        Product existingProduct = productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found"));
        
        existingProduct.setName(productDto.getName());
        existingProduct.setPrice(productDto.getPrice()); // No conversion needed
        existingProduct.setExpiryDate(productDto.getExpiryDate());

        Product updatedProduct = productRepository.save(existingProduct);
        return productMapper.toDto(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(id);
    }
}
