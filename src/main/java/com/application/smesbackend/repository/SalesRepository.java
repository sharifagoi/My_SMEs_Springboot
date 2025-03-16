package com.application.smesbackend.repository;

import com.application.smesbackend.entity.Sales;
import com.application.smesbackend.dto.DailySalesDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

    @Query("SELECT new com.application.smesbackend.dto.DailySalesDto(s.date, SUM(s.quantity), SUM(s.total)) " +
           "FROM Sales s GROUP BY s.date")
    List<DailySalesDto> findDailySales();

    @Query("SELECT s FROM Sales s ORDER BY s.date DESC")
    List<Sales> findLatestSales();

    @Query("SELECT s FROM Sales s WHERE s.type = 'product'")
    List<Sales> findAllProducts();
}