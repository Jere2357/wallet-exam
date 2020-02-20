package com.example.walletexam.repository;

import com.example.walletexam.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<WalletEntity, Long> {
    List<WalletEntity> findAllByFirstName(String firstName);
    List<WalletEntity> findAllByWalletBalance(Double walletBalance);
}
