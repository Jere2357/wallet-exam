package com.example.walletexam.controller;

import com.example.walletexam.dto.Create;
import com.example.walletexam.dto.Transfer;
import com.example.walletexam.entity.WalletEntity;
import com.example.walletexam.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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
    public void updateRecords(@RequestBody Create createWallet, @PathVariable Long id) {
        System.out.println(createWallet);
        walletService.updateRecords(createWallet, id);
    }

    @PutMapping(path = "top-up/{id}")
    public void topUp(@RequestBody Create createWallet, @PathVariable Long id) {
        walletService.topUp(createWallet, id);
    }

    @PutMapping(path = "withdraw/{id}")
    public void withdrawWallet(@RequestBody Create createWallet, @PathVariable Long id) {
        walletService.withdrawWallet(createWallet, id);
    }

    @PutMapping(path = "transfer/{id}")
    public void transferWallet(@RequestBody Transfer transfer, @PathVariable Long id) {
        walletService.transferWallet(transfer, id);
    }
}
