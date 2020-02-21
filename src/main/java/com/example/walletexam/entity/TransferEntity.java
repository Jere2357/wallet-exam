package com.example.walletexam.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transfer_table")
public class TransferEntity {

    @Id
    @Column
    private Long transferTo;

    @Column
    private Double transferBalance;

}
