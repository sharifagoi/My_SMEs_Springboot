package com.application.smesbackend.repository;

import com.application.smesbackend.entity.Product;
import com.application.smesbackend.entity.Sales;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
     @Query("SELECT s FROM Sales s WHERE LOWER(s.type) = 'product'")
    List<Sales> findAllProducts();
}