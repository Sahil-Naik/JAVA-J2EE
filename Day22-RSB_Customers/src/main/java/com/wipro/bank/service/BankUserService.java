package com.wipro.bank.service;

import com.wipro.bank.model.Bank;
import com.wipro.bank.repository.BankREPO;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@AllArgsConstructor
public class BankUserService {
	
	@Autowired
    private BankREPO repository;

    public Mono<Bank> addAccount(Bank account) {
        return repository.save(account);
    }

    public Flux<Bank> getAllAccounts() {
        return repository.findAll();
    }

    public Mono<Bank> updateAccount(Integer id, Bank account) {
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
