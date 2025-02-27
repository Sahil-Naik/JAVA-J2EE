package com.wipro.bank.service;

import com.wipro.bank.model.BankUser;
import com.wipro.bank.repository.BankUserRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class BankUserService {
	@Autowired
	private BankUserRepository bankUserRepository;
	
	public BankUser addBankUser(BankUser bankUser) {
		return bankUserRepository.save(bankUser);
	}
	
	public List<BankUser> getAllBankUsers(){
		return bankUserRepository.findAll();
	}
	
	public BankUser getBankUserById(int id) {
		return bankUserRepository.findById(id).orElse(null);
	}
}
