package com.application.smesbackend.service.impl;

import com.application.smesbackend.dto.DailySalesDto;
import com.application.smesbackend.dto.SalesDto;
import com.application.smesbackend.dto.Profit;
import com.application.smesbackend.entity.Sales;
import com.application.smesbackend.mapper.SalesMapper;
import com.application.smesbackend.repository.SalesRepository;
import com.application.smesbackend.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private SalesMapper salesMapper;

    @Override
    public SalesDto recordSales(SalesDto salesDto) {
        Sales sales = salesMapper.toEntity(salesDto);
        sales.setDate(LocalDateTime.now().toString()); // Set the date field
        if (sales.getType() == null) {
            sales.setType("default"); // Ensure the type field is set
        }
        Sales savedSales = salesRepository.save(sales);
        return salesMapper.toDto(savedSales);
    }

    @Override
    public List<DailySalesDto> getDailySales() {
        return salesRepository.findDailySales();
    }

    @Override
    public List<SalesDto> getLatestSales() {
        List<Sales> latestSales = salesRepository.findLatestSales();
        return latestSales.stream()
                .map(salesMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SalesDto addProduct(SalesDto salesDto) {
        Sales sales = salesMapper.toEntity(salesDto);
        sales.setDate(LocalDateTime.now().toString()); // Set the date field
        if (sales.getType() == null) {
            sales.setType("product"); // Ensure the type field is set
        }
        Sales savedSales = salesRepository.save(sales);
        return salesMapper.toDto(savedSales);
    }

    @Override
    public List<SalesDto> getStock() {
        List<Sales> salesList = salesRepository.findAll();
        return salesList.stream()
                .map(salesMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SalesDto> getAllProducts() {
        List<Sales> products = salesRepository.findAllProducts();
        return products.stream()
                .map(salesMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteStock(Long id) {
        salesRepository.deleteById(id);
    }

    @Override
    public Profit calculateProfit() {
        List<Sales> salesList = salesRepository.findAll();
        double totalRevenue = salesList.stream()
                .mapToDouble(sales -> Double.parseDouble(sales.getTotal()))
                .sum();
        double totalCost = salesList.stream()
                .mapToDouble(sales -> Double.parseDouble(sales.getPrice()) * Double.parseDouble(sales.getQuantity()))
                .sum();
        double netProfit = totalRevenue - totalCost;
        return new Profit(totalRevenue, totalCost, netProfit);
    }
}