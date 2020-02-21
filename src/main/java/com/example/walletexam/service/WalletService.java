package com.example.walletexam.service;

import com.example.walletexam.dto.Create;
import com.example.walletexam.entity.WalletEntity;
import com.example.walletexam.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

@Service
public class WalletService {
    private WalletRepository walletRepository;

    @Autowired
    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public List<WalletEntity> getAll() {
        return walletRepository.findAll();
    }

    public Create postWallet(Create createWallet) {
        WalletEntity walletEntity = WalletEntity.builder()
                .firstName(createWallet.getFirstName())
                .lastName(createWallet.getLastName())
                .email(createWallet.getEmail())
                .birthDate(createWallet.getBirthDate())
                .walletBalance(createWallet.getWalletBalance())
                .transactionDate(LocalDate.now())
                .transactionType("created wallet")
                .build();
        walletRepository.save(walletEntity);
        System.out.println("I AM HERE" + createWallet.toString());
        return createWallet;
    }

    public WalletEntity getById(Long id) {
        return walletRepository
                .findById(id)
                .orElse(null);
    }

    public Double getWalletBalance(Long id) {
        return walletRepository
                .findById(id)
                .orElse(null).getWalletBalance();
    }

    public void updateById(Create createWallet, Long id) {
        WalletEntity walletEntityUpdate = walletRepository.getOne(id);
        walletEntityUpdate.setFirstName(createWallet.getFirstName());
        walletEntityUpdate.setLastName(createWallet.getLastName());
        walletEntityUpdate.setEmail(createWallet.getEmail());
        walletEntityUpdate.setBirthDate(createWallet.getBirthDate());
        walletEntityUpdate.setWalletBalance(createWallet.getWalletBalance()+getWalletBalance(id));
        walletRepository.save(walletEntityUpdate);
    }

    public void topUp(Create createWallet, Long id) {
        WalletEntity walletEntityUpdate = walletRepository.getOne(id);
        walletEntityUpdate.setWalletBalance(createWallet.getWalletBalance()+getWalletBalance(id));
        walletEntityUpdate.setTransactionDate(LocalDate.now());
        walletEntityUpdate.setTransactionType("top up");
        walletRepository.save(walletEntityUpdate);
    }

    public void withdrawWallet(Create createWallet, Long id) {
        WalletEntity walletEntityUpdate = walletRepository.getOne(id);
        walletEntityUpdate.setWalletBalance(Math.abs(createWallet.getWalletBalance()-getWalletBalance(id)));
        walletEntityUpdate.setTransactionDate(LocalDate.now());
        walletEntityUpdate.setTransactionType("withdraw");
        walletRepository.save(walletEntityUpdate);
    }

    public List<WalletEntity> getAllByFirstName(@PathVariable String firstName) {
        return walletRepository.findAllByFirstName(firstName);
    }

    public void removeById(Long id) {
        walletRepository.deleteById(id);
    }
}
