package com.application.smesbackend.controller;

import com.application.smesbackend.dto.DailySalesDto;
import com.application.smesbackend.dto.SalesDto;
import com.application.smesbackend.dto.Profit;
import com.application.smesbackend.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @PostMapping("/record")
    public ResponseEntity<SalesDto> recordSales(@RequestBody SalesDto salesDto) {
        SalesDto recordedSales = salesService.recordSales(salesDto);
        return new ResponseEntity<>(recordedSales, HttpStatus.CREATED);
    }

    @GetMapping("/daily")
    public ResponseEntity<List<DailySalesDto>> getDailySales() {
        List<DailySalesDto> dailySales = salesService.getDailySales();
        return new ResponseEntity<>(dailySales, HttpStatus.OK);
    }

    @GetMapping("/latest")
    public ResponseEntity<List<SalesDto>> getLatestSales() {
        List<SalesDto> latestSales = salesService.getLatestSales();
        return new ResponseEntity<>(latestSales, HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<SalesDto> addProduct(@RequestBody SalesDto salesDto) {
        SalesDto addedProduct = salesService.addProduct(salesDto);
        return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<List<SalesDto>> getAllProducts() {
        List<SalesDto> products = salesService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/stock")
    public ResponseEntity<List<SalesDto>> getStock() {
        List<SalesDto> stock = salesService.getStock();
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        salesService.deleteStock(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/profit")
    public ResponseEntity<Profit> getProfit() {
        Profit profit = salesService.calculateProfit();
        return new ResponseEntity<>(profit, HttpStatus.OK);
    }
}