package com.takeo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stock_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_Id")
    private int userId;
    @NotEmpty
    @Column(name = "user_name")
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
