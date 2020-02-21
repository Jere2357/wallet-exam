package com.example.walletexam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TransactionHistory {
    private String transactionType;
    private LocalDate transactionDate;
}
