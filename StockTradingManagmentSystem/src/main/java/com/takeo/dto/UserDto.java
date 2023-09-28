package com.takeo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.takeo.entity.Portfolio;
import com.takeo.entity.TradingAccount;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {
    private String userName;
    @Email
    @Column(name = "email")
    private String email;
    @JsonIgnore
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy ="user", cascade = CascadeType.ALL)
    private List<Portfolio> portfolio;

    @OneToMany(mappedBy ="user", cascade = CascadeType.ALL)
    private List<TradingAccount> tradingAccounts;

}
