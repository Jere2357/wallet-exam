package com.example.walletexam.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "test_table")
@SecondaryTables({
        @SecondaryTable(name = "transaction_table", pkJoinColumns = @PrimaryKeyJoinColumn(name = "transaction_id"))
})
public class WalletEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private LocalDate birthDate;

    @Column
    private Double walletBalance;

    @Column(name="transactionType", table="transaction_table")
    private String transactionType;

    @Column(name="transactionDate", table="transaction_table")
    private LocalDate transactionDate;
}
