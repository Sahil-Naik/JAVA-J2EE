package com.wipro.bank.service;

import com.wipro.bank.model.BankUser;
import com.wipro.bank.repository.BankUserRepository;
import com.wipro.bank.DTO.BankUserDTO;
import com.wipro.bank.DTO.BankUserRequestDTO;
import com.wipro.bank.exceptions.*;

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
	
	public BankUser addBankUser(BankUserRequestDTO dto) {
	    BankUser bankUser = new BankUser();
	    bankUser.setHolderName(dto.getHolderName());
	    bankUser.setPhone(dto.getPhone());
	    bankUser.setHolderDob(dto.getHolderDob());
	    bankUser.setAccountPin(dto.getAccountPin());
	    bankUser.setBalance(dto.getBalance());

	    return bankUserRepository.save(bankUser);
	}
	
	public List<BankUser> getAllBankUsers(){
		return bankUserRepository.findAll();
	}
	
	public BankUserDTO getBankUserById(int id) {
	    BankUser user = bankUserRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee " + id + " not found."));
	    
	    // Convert to DTO before returning
	    return new BankUserDTO(user.getAccountId(), user.getHolderName(), user.getBalance());
	}
	
	public BankUser updateBankUser(int id, BankUser updatedBankUser) {
		Optional<BankUser> existingBankUser = bankUserRepository.findById(id);
		if (existingBankUser.isPresent()) {
			BankUser BU = existingBankUser.get();
			BU.setHolderName(updatedBankUser.getHolderName());
			BU.setHolderDob(updatedBankUser.getHolderDob());
			BU.setPhone(updatedBankUser.getPhone());
			BU.setAccountPin(updatedBankUser.getAccountPin());
			BU.setBalance(updatedBankUser.getBalance());
			return bankUserRepository.save(BU);
		}
		return null;
	}
	
	public List<BankUser> getBankUserBalanceGreaterThan(int balance){
		return bankUserRepository.findBankUserBalanceGreaterThan(balance);
	}
	
	public List<BankUser> getBankUserBalanceLessThan(int balance){
		return bankUserRepository.findBankUserBalanceLessThan(balance);
	}
	
	public Page<BankUser> getBankUserPaged(int page, int size, String sortBy, String direction){
		Sort sort = direction.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(page, size, sort);
		return bankUserRepository.findAll(pageable);
	}
	
	public void deleteBankUser(int id, int pin) {
	    BankUser existingBankuser = bankUserRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Bank user with ID " + id + " does not exist."));

	    // Check if the provided PIN matches the stored PIN
	    if (existingBankuser.getAccountPin() != pin) {
	        throw new InvalidPinException("Invalid PIN.");
	    }

	    // If PIN is correct, proceed with deletion
	    bankUserRepository.delete(existingBankuser);
	}
}
