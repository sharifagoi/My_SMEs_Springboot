package com.application.smesbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String quantity;

    @Column(nullable = false)
    private String price;

    @Column(nullable = false)
    private String total;

    @Column(nullable = false)
    private String date;
    
    @Column(nullable = false)
    private String type; // Added type attribute
}
