package com.wipro.controller;

import com.wipro.model.Bank;
import com.wipro.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping
    public Flux<Bank> getAllBanks() {
        return bankService.getAllBanks();
    }

    @GetMapping("/{id}")
    public Mono<Bank> getBankById(@PathVariable Integer id) {
        return bankService.getBankById(id);
    }

    @PostMapping
    public Mono<Bank> saveBank(@RequestBody Bank bank) {
        return bankService.saveBank(bank);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteBank(@PathVariable Integer id) {
        return bankService.deleteBank(id);
    }
}
