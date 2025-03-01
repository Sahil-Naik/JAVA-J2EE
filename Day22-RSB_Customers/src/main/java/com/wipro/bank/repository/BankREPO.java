package com.wipro.bank.repository;

import com.wipro.bank.model.BankUser;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BankREPO extends ReactiveCrudRepository<BankUser, Integer> {
	
}
