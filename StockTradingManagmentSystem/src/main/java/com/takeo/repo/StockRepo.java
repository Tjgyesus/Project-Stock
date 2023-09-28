package com.takeo.repo;

import com.takeo.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepo extends JpaRepository<Stock, Integer> {
}
