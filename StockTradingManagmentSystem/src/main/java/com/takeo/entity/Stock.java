package com.takeo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String stockSymbol;
    private int quantity;
    private BigDecimal price;

    private Date transactionDate;

    @ManyToOne
    private Portfolio portfolio;
}


