package com.wipro.bank.controller;

import com.wipro.bank.exceptions.InvalidPinException;
import com.wipro.bank.exceptions.ResourceNotFoundException;
import com.wipro.bank.model.Bank;
import com.wipro.bank.service.BankUserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

	@GetMapping("/details")
	@CircuitBreaker(name = "BankUserService", fallbackMethod = "fallbackGetBankDetails")
	public String getBankDetails() {
		return BankUserService.getBankDetails();
	}

	public String fallbackGetBankDetails(Exception e) {
		return "Fallback: Bank service is currently unavailable.";
	}

	@PostMapping("/add")
	public ResponseEntity<Mono<Bank>> addBankUser(@Valid @RequestBody Bank newBankUser) {
		Bank BU = new Bank();
		BU.setHolderName(newBankUser.getHolderName());
		BU.setHolderDob(newBankUser.getHolderDob());
		BU.setPhone(newBankUser.getPhone());
		BU.setAccountPin(newBankUser.getAccountPin());
		BU.setBalance(newBankUser.getBalance());

		Mono<Bank> savedBankUser = bankUserService.addBankUser(BU);
		return ResponseEntity.ok(savedBankUser);
	}

	@GetMapping("/all")
	public Flux<Bank> getAllBankUsers() {
		return bankUserService.getAllBankUsers();
	}

	@GetMapping("/{id}")
	public Mono<Bank> getBankUserById(@PathVariable int id) {
		return bankUserService.getBankUserById(id);
	}

	@GetMapping("/balance-greater-than")
	public Flux<Bank> getBankUserBalanceGreaterThan(@RequestParam int balance) {
		return bankUserService.getBankUserBalanceGreaterThan(balance);
	}

	@GetMapping("/balance-less-than")
	public Flux<Bank> getBankUserBalanceLessThan(@RequestParam int balance) {
		return bankUserService.getBankUserBalanceLessThan(balance);
	}

	@GetMapping("/paginate")
	public Mono<Page<Bank>> getBankUsers(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "customerCity") String sortBy,
			@RequestParam(defaultValue = "asc") String direction) {
		return bankUserService.getBankUserPaged(page, size, sortBy, direction);
	}

	@PutMapping("/update/{id}")
	public Mono<Bank> updateBankUser(@PathVariable int id, @RequestBody Bank updatedBankUser) {
		return bankUserService.updateBankUser(id, updatedBankUser);
	}

	@DeleteMapping("/delete/{id}-{pin}")
	public Mono<ResponseEntity<String>> deleteCustomer(@PathVariable int id, @PathVariable int pin) {
		return bankUserService.deleteBankUser(id, pin)
				.then(Mono.just(ResponseEntity.ok("Bank user with ID " + id + " has been deleted.")))
				.onErrorResume(e -> {
					if (e instanceof InvalidPinException) {
						return Mono.just(ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage()));
					} else if (e instanceof ResourceNotFoundException) {
						return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()));
					}
					return Mono
							.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred."));
				});
	}

}
