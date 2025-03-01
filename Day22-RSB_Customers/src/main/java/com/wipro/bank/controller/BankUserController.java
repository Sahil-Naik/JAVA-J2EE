package com.wipro.bank.controller;

import com.wipro.bank.model.Bank;
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
    public Mono<Bank> addAccount(@RequestBody Bank account) {
        return service.addAccount(account);
    }

    @GetMapping("/all")
    public Flux<Bank> getAllAccounts() {
        return service.getAllAccounts();
    }

    @PutMapping("/{id}")
    public Mono<Bank> updateAccount(@PathVariable Integer id, @RequestBody Bank account) {
        return service.updateAccount(id, account);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteAccount(@PathVariable Integer id) {
        return service.deleteAccount(id);
    }
}
