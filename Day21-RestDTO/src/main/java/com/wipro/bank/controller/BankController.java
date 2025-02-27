package com.wipro.bank.controller;

import com.wipro.bank.DTO.BankUserDTO;
import com.wipro.bank.model.BankUser;
import com.wipro.bank.service.BankUserService;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bank")
public class BankController {
	
	@Autowired
	private BankUserService bankUserService;
	
	@PostMapping("/add")
	public ResponseEntity<BankUser> addBankUser(@Valid @RequestBody BankUser newBankUser){
		BankUser BU = new BankUser();
		BU.setHolderName(newBankUser.getHolderName());
		BU.setHolderDob(newBankUser.getHolderDob());
		BU.setPhone(newBankUser.getPhone());
		BU.setAccountPin(newBankUser.getAccountPin());
		BU.setBalance(newBankUser.getBalance());
		
		BankUser savedBankUser = bankUserService.addBankUser(BU);
		return ResponseEntity.ok(savedBankUser);
	}
	
	@GetMapping("/view-all")
	public List<BankUser> getAllBankUsers(){
		return bankUserService.getAllBankUsers();
	}
	
	@GetMapping("/getid-{id}")
	public ResponseEntity<BankUserDTO> getBankUser(@PathVariable int id) {
	    BankUserDTO userDTO = bankUserService.getBankUserById(id);
	    return ResponseEntity.ok(userDTO);
	}
	
	@GetMapping("/balance-greater-than")
	public List<BankUser> getBankUserBalanceGreaterThan(
			@RequestParam int balance){
		return bankUserService.getBankUserBalanceGreaterThan(balance);
	}
	
	@GetMapping("/balance-less-than")
	public List<BankUser> getBankUserBalanceLessThan(
			@RequestParam int balance){
		return bankUserService.getBankUserBalanceLessThan(balance);
	}
	
	@GetMapping("/paginate")
    public Page<BankUser> getBankUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "customerCity") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        return bankUserService.getBankUserPaged(page, size, sortBy, direction);
    }
	
	@PutMapping("/update/{id}")
	public BankUser updateBankUser(@PathVariable int id, @RequestBody BankUser updatedBankUser) {
		return bankUserService.updateBankUser(id, updatedBankUser);
	}
	
	@DeleteMapping("/delete/{id}-{pin}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id, @PathVariable int pin) {
	    bankUserService.deleteBankUser(id, pin);
	    return ResponseEntity.ok("Bank user with ID " + id + " has been deleted.");
	}

}
