package com.application.smesbackend.controller;

import com.application.smesbackend.entity.RecycleBin;
import com.application.smesbackend.repository.RecycleBinRepository;
import com.application.smesbackend.repository.UserRepository;
import com.application.smesbackend.repository.ProductRepository;
import com.application.smesbackend.repository.SalesRepository;
import com.application.smesbackend.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/delete")
public class DeleteController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private RecycleBinRepository recycleBinRepository;

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        var user = userRepository.findById(id);
        if (user.isPresent()) {
            recycleBinRepository.save(new RecycleBin(null, "User", id.toString(), user.get().getName()));
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        var product = productRepository.findById(id);
        if (product.isPresent()) {
            recycleBinRepository.save(new RecycleBin(null, "Product", id.toString(), product.get().getName()));
            productRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/sales/{id}")
    public ResponseEntity<?> deleteSales(@PathVariable Long id) {
        var sales = salesRepository.findById(id);
        if (sales.isPresent()) {
            recycleBinRepository.save(new RecycleBin(null, "Sales", id.toString(), sales.get().getName()));
            salesRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/stock/{id}")
    public ResponseEntity<?> deleteStock(@PathVariable Long id) {
        var stock = stockRepository.findById(id);
        if (stock.isPresent()) {
            recycleBinRepository.save(new RecycleBin(null, "Stock", id.toString(), stock.get().getName()));
            stockRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}