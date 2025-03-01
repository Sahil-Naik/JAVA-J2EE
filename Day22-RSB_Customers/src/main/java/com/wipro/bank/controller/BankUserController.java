package com.wipro.bank.controller;

import com.wipro.bank.model.BankUser;
import com.wipro.bank.service.BankUserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bank")
public class BankUserController {
    @Autowired
    private BankUserService service;

    @PostMapping("/add")
    public Mono<BankUser> addAccount(@RequestBody BankUser account) {
        return service.addAccount(account);
    }

    @GetMapping("/all")
    public Flux<BankUser> getAllAccounts() {
        return service.getAllAccounts();
    }

    @PutMapping("/{id}")
    public Mono<BankUser> updateAccount(@PathVariable Integer id, @RequestBody BankUser account) {
        return service.updateAccount(id, account);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteAccount(@PathVariable Integer id) {
        return service.deleteAccount(id);
    }
}
