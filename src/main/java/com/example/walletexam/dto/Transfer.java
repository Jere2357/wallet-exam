package com.example.walletexam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transfer {
    private Long transferTo;
    private Double transferBalance;
}
