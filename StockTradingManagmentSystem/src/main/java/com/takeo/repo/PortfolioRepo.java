package com.takeo.repo;

import com.takeo.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepo extends JpaRepository<Portfolio, Integer> {
}
