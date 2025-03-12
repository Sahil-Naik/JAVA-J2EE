package com.wipro.service;

import com.wipro.model.Bank;
import com.wipro.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public Flux<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    public Mono<Bank> getBankById(Integer id) {
        return bankRepository.findById(id);
    }

    public Mono<Bank> saveBank(Bank bank) {
        return bankRepository.save(bank);
    }

    public Mono<Void> deleteBank(Integer id) {
        return bankRepository.deleteById(id);
    }
}
