package com.example.walletexam.controller;

import com.example.walletexam.dto.Create;
import com.example.walletexam.entity.WalletEntity;
import com.example.walletexam.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "wallet")
public class WalletController {
    private WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping(path = "records")
    public List<WalletEntity> getAll() {
        return walletService.getAll();
    }

    @PostMapping(path = "records")
    @ResponseStatus(HttpStatus.CREATED)
    public Create postDTO(@RequestBody Create createWallet) {
        System.out.println(createWallet);
        return walletService.postWallet(createWallet);
    }

    @GetMapping(path = "records/{id}")
    public WalletEntity getById(@PathVariable Long id) {
        return walletService.getById(id);
    }

    @GetMapping(path = "records/firstName/{firstName}")
    public List<WalletEntity> getAllByFirstName(@PathVariable String firstName) {
        return walletService.getAllByFirstName(firstName);
    }

    @DeleteMapping(path = "records/{id}")
    public void removeById(@PathVariable Long id) {
        walletService.removeById(id);
    }

    @PutMapping(path = "records/{id}")
    public void updateById(@RequestBody Create createWallet, @PathVariable Long id) {
        System.out.println(createWallet);
        walletService.updateById(createWallet, id);
    }

    @PutMapping(path = "records/topUp/{id}")
    public void topUp(@RequestBody Create createWallet, @PathVariable Long id) {
        System.out.println(createWallet);
        walletService.topUp(createWallet, id);
    }

    @PutMapping(path = "records/withdraw/{id}")
    public void withdrawWallet(@RequestBody Create createWallet, @PathVariable Long id) {
        System.out.println(createWallet);
        walletService.withdrawWallet(createWallet, id);
    }
}
