package com.application.smesbackend.service;

import com.application.smesbackend.dto.DailySalesDto;
import com.application.smesbackend.dto.SalesDto;
import com.application.smesbackend.dto.Profit;

import java.util.List;

public interface SalesService {
    SalesDto recordSales(SalesDto salesDto);
    List<DailySalesDto> getDailySales();
    List<SalesDto> getLatestSales();
    SalesDto addProduct(SalesDto salesDto);
    List<SalesDto> getStock();
    List<SalesDto> getAllProducts();
    void deleteStock(Long id);
    Profit calculateProfit();
}