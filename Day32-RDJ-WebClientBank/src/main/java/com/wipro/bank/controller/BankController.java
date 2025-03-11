package com.wipro.bank.controller;

import com.wipro.bank.DTO.*;
import com.wipro.bank.model.*;
import com.wipro.bank.service.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
@RequestMapping("bank")
@Tag(name = "Bank Management System", description = "Operations related to banking")
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping("/add")
    @Operation(summary = "Add a new bank user", description = "Adds a new bank user record to the database")
    public Mono<ResponseEntity<Bank>> addBankUser (@Valid @RequestBody Bank newBankUser ) {
        Bank bankToSave = new Bank();
        bankToSave.setHolder_name(newBankUser .getHolder_name());
        bankToSave.setHolder_phone(newBankUser .getHolder_phone());
        bankToSave.setBalance(newBankUser .getBalance());
        bankToSave.setVendor_name(newBankUser .getVendor_name());

        return bankService.addBankUser (bankToSave)
                .map(savedBankUser  -> ResponseEntity.ok(savedBankUser ));
    }

    @GetMapping("/all")
    @Operation(summary = "View all Bank users", description = "Displays all Bank users records")
    public Flux<Bank> getAllBankUsers() {
        return bankService.getAllBankUsers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "View Bank user with ID", description = "Displays Customer records with ID x")
    public Mono<ResponseEntity<BankDTO>> getBankUser (@PathVariable int id) {
        return bankService.getBankUserById(id)
                .map(bankDTO -> ResponseEntity.ok(bankDTO))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update Bank user", description = "Updates a bank user with given ID")
    public Mono<ResponseEntity<Bank>> updateBankUser (@PathVariable int id, @RequestBody Bank updatedBankUser ) {
        return bankService.updateBankUser (id, updatedBankUser )
                .map(updatedBank -> ResponseEntity.ok(updatedBank))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Customer", description = "Deletes a Customer with given ID")
    public Mono<ResponseEntity<String>> deleteBankUser (@PathVariable int id) {
        return bankService.deleteBankUser (id)
                .then(Mono.just(ResponseEntity.ok("Bank user with ID " + id + " has been deleted.")))
                .onErrorReturn(ResponseEntity.notFound().build());
    }
}
