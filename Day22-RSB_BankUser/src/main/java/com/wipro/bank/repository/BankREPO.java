package com.wipro.bank.repository;

import com.wipro.bank.model.Bank;

import reactor.core.publisher.Flux;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankREPO extends R2dbcRepository<Bank, Integer> {
    //Flux<BankUser> findByTitleContaining(String title);
}
