package com.wipro.bank.service;

import com.wipro.bank.model.BankUser;
import com.wipro.bank.repository.BankREPO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BankUserService {
    private final BankREPO repository;
    
    public BankUserService(BankREPO repository) {
        this.repository = repository;
    }

    public Mono<BankUser> addAccount(BankUser account) {
        return repository.save(account);
    }

    public Flux<BankUser> getAllAccounts() {
        return repository.findAll();
    }

    public Mono<BankUser> updateAccount(Integer id, BankUser account) {
        return repository.findById(id)
                .flatMap(existingAccount -> {
                    existingAccount.setHolderName(account.getHolderName());
                    existingAccount.setPhone(account.getPhone());
                    existingAccount.setAccountPin(account.getAccountPin());
                    existingAccount.setHolderDob(account.getHolderDob());
                    existingAccount.setBalance(account.getBalance());
                    return repository.save(existingAccount);
                });
    }

    public Mono<Void> deleteAccount(Integer id) {
        return repository.deleteById(id);
    }
}
