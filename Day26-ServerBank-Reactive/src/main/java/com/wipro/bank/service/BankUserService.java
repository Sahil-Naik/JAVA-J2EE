package com.wipro.bank.service;

import com.wipro.bank.model.Bank;
import com.wipro.bank.repository.BankUserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.wipro.bank.exceptions.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.Random;

@RefreshScope
@Service
public class BankUserService {
	@Autowired
	private BankUserRepository bankUserRepository;
	
	public Mono<Bank> addBankUser(Bank bankUser) {
		return bankUserRepository.save(bankUser);
	}
	
	public Flux<Bank> getAllBankUsers(){
		return bankUserRepository.findAll();
	}
	
	public Mono<Bank> getBankUserById(int id) {
	    return bankUserRepository.findById(id)
	        .switchIfEmpty(Mono.error(new ResourceNotFoundException("User  with ID " + id + " not found.")));
	}
	
	public Mono<Bank> updateBankUser(int id, Bank updatedBankUser) {
	    return bankUserRepository.findById(id)
	        .flatMap(existingBankUser  -> {
	            existingBankUser.setHolderName(updatedBankUser.getHolderName());
	            existingBankUser.setHolderDob(updatedBankUser.getHolderDob());
	            existingBankUser.setPhone(updatedBankUser.getPhone());
	            existingBankUser.setAccountPin(updatedBankUser.getAccountPin());
	            existingBankUser.setBalance(updatedBankUser.getBalance());
	            return bankUserRepository.save(existingBankUser);
	        }).switchIfEmpty(Mono.error(new ResourceNotFoundException("User  with ID " + id + " not found.")));
	}
	
	public Flux<Bank> getBankUserBalanceGreaterThan(int balance){
		return bankUserRepository.findByBalanceGreaterThan(balance);
	}
	
	public Flux<Bank> getBankUserBalanceLessThan(int balance){
		return bankUserRepository.findByBalanceLessThan(balance);
	}
	
	public Mono<Page<Bank>> getBankUserPaged(int page, int size, String sortBy, String direction) {
	    Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
	    Pageable pageable = PageRequest.of(page, size, sort);

	    return bankUserRepository.findAll((Sort) pageable)
	        .collectList()
	        .zipWith(bankUserRepository.count())
	        .map(tuple -> new PageImpl<>(tuple.getT1(), pageable, tuple.getT2()));
	}
	
	public Mono<Void> deleteBankUser (int id, int pin) {
	    return bankUserRepository.findById(id)
	        .flatMap(existingBankUser  -> {
	            // Check if the provided PIN matches the stored PIN
	            if (existingBankUser.getAccountPin() != pin) {
	                return Mono.error(new InvalidPinException("Invalid PIN."));
	            }
	            // If PIN is correct, proceed with deletion
	            return bankUserRepository.delete(existingBankUser );
	        })
	        .then(); // Return Mono<Void> after deletion
	}
	
    public static String getBankDetails() {
        // Simulating a failure or delay
        if (new Random().nextBoolean()) {
            throw new RuntimeException("Bank service is down");
        }
        return "Bank details fetched successfully!";
    }
	
}
