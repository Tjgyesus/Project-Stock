package com.takeo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Portfolio {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long accountNo;
   private String name;
   @Email
   private String email;
   @ManyToOne
   private User user;

   @OneToMany(mappedBy = "portfolio")
   private List<Transaction> transactions;

}
