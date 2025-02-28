package com.wipro.controller;

import com.wipro.DTO.BankUserDTO;
import com.wipro.DTO.BankUserRequestDTO;
import com.wipro.model.BankUser;
import com.wipro.service.BankUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.awt.print.Pageable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/bank")
@Tag(name = "Bank Management System", description = "Operations related to handling bank user")
public class BankController {
	
	@Autowired
	private BankUserService bankUserService;
	
	@PostMapping("/add")
	@Operation(summary = "Add a new bank user", description = "Adds a new bank user record to the database")
	public ResponseEntity<BankUser> addBankUser(@Valid @RequestBody BankUserRequestDTO dto) {
	    BankUser savedUser = bankUserService.addBankUser(dto);
	    return ResponseEntity.ok(savedUser);
	}
	
	@GetMapping("/view-all")
	@Operation(summary = "View all bank users", description = "Displays all bank users from the database")
	public List<BankUser> getAllBankUsers(){
		return bankUserService.getAllBankUsers();
	}
	
	@GetMapping("/getid-{id}")
	@Operation(summary = "View a bank user", description = "Returns a bank user with specified ID")
	public ResponseEntity<BankUserDTO> getBankUser(@PathVariable int id) {
	    BankUserDTO userDTO = bankUserService.getBankUserById(id);
	    return ResponseEntity.ok(userDTO);
	}
	
	@GetMapping("/balance-greater-than")
	@Operation(summary = "User with balance greater than", description = "Returns a bank user having balance greater than")
	public List<BankUser> getBankUserBalanceGreaterThan(
			@RequestParam int balance){
		return bankUserService.getBankUserBalanceGreaterThan(balance);
	}
	
	@GetMapping("/balance-less-than")
	@Operation(summary = "User with balance greater less", description = "Returns a bank user having balance greater less")
	public List<BankUser> getBankUserBalanceLessThan(
			@RequestParam int balance){
		return bankUserService.getBankUserBalanceLessThan(balance);
	}
	
	@GetMapping("/paginate")
	@Operation(summary = "Paged results", description = "Returns all bank user in paged manner")
    public Page<BankUser> getBankUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "accountId") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        return bankUserService.getBankUserPaged(page, size, sortBy, direction);
    }
	
	@PutMapping("/update/{id}")
	@Operation(summary = "Update user", description = "Updates a user with given ID")
	public BankUser updateBankUser(@PathVariable int id, @RequestBody BankUser updatedBankUser) {
		return bankUserService.updateBankUser(id, updatedBankUser);
	}
	
	@DeleteMapping("/delete/{id}-{pin}")
	@Operation(summary = "Delete user", description = "Deletes a user with given ID and PIN")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id, @PathVariable int pin) {
	    bankUserService.deleteBankUser(id, pin);
	    return ResponseEntity.ok("Bank user with ID " + id + " has been deleted.");
	}

}
