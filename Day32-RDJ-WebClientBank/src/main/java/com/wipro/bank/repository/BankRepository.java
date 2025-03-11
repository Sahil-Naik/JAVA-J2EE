package com.wipro.bank.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.wipro.bank.model.Bank;

@Repository
public interface BankRepository extends ReactiveCrudRepository<Bank, Integer> {
}
