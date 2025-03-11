package com.wipro.bank.service;

import com.wipro.bank.exception.ResourceNotFoundException;
import com.wipro.bank.DTO.BankDTO;
import com.wipro.bank.model.Bank;
import com.wipro.bank.repository.BankRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.List;
import java.util.Optional;

@Service
@RefreshScope
public class BankService {

	@Autowired
    private BankRepository bankRepository;
	
	public Mono<Bank> addBankUser(Bank bankUser) {
		return bankRepository.save(bankUser);
	}
	
	public Flux<Bank> getAllBankUsers(){
		return bankRepository.findAll();
	}
	
	public Mono<BankDTO> getBankUserById(int id) {
	    return bankRepository.findById(id)
	            .map(bank -> new BankDTO(bank.getAccountId(),
	                    bank.getHolder_name(),
	                    bank.getHolder_phone(),
	                    bank.getBalance(),
	                    bank.getVendor_name()))
	            .switchIfEmpty(Mono.error(new ResourceNotFoundException("Bank user with ID " + id + " not found.")));
	}

	public Mono<Bank> updateBankUser (int id, Bank updatedBankUser ) {
	    return bankRepository.findById(id)
	            .flatMap(existingBankUser  -> {
	                existingBankUser .setHolder_name(updatedBankUser .getHolder_name());
	                existingBankUser .setHolder_phone(updatedBankUser .getHolder_phone());
	                existingBankUser .setBalance(updatedBankUser .getBalance());
	                existingBankUser .setVendor_name(updatedBankUser .getVendor_name());
	                return bankRepository.save(existingBankUser );
	            })
	            .switchIfEmpty(Mono.error(new ResourceNotFoundException("Bank user with id " + id + " not found.")));
	}

	public Mono<Void> deleteBankUser (int id) {
	    return bankRepository.existsById(id)
	            .flatMap(exists -> {
	                if (!exists) {
	                    return Mono.error(new ResourceNotFoundException("Bank user with id " + id + " not found."));
	                }
	                return bankRepository.deleteById(id);
	            });
	}
}
