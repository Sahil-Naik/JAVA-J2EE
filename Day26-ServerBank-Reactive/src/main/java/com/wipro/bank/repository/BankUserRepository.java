package com.wipro.bank.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import com.wipro.bank.model.Bank;

import reactor.core.publisher.Flux;

@Repository
public interface BankUserRepository extends R2dbcRepository<Bank, Integer> {
    
	Flux<Bank> findByBalanceGreaterThan(int balance);

    Flux<Bank> findByBalanceLessThan(int balance);
}
