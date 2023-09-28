package com.takeo.repo;


import com.takeo.entity.TradingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradingAccountRepo extends JpaRepository<TradingAccount, Integer> {
}
