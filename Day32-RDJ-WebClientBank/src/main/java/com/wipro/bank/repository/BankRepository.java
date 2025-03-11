package com.wipro.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wipro.bank.model.Bank;

import reactor.core.publisher.Flux;

@SuppressWarnings("unused")
@Repository
public interface BankRepository extends R2dbcRepository<Bank, Integer> {
	//Flux<Bank> findByBalanceGreaterThan(int balance);
}
