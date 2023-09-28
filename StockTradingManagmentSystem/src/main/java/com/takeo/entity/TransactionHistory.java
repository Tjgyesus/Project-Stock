package com.takeo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class TransactionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transactionType; // e.g., deposit, withdrawal, stock purchase, stock sale
    private BigDecimal amount;
    private Date transactionDate;

    @ManyToOne
    private TradingAccount tradingAccount;
}
