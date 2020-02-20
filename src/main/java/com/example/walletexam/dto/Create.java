package com.example.walletexam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Create {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private Double walletBalance;
}
