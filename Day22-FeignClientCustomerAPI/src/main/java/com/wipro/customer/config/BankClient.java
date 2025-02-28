package com.wipro.customer.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.customer.DTO.BankDTO;

@FeignClient(name = "bankClient", url = "http://localhost:6061")
public interface BankClient {

    @GetMapping("/api/bank/{customerBankId}")
    BankDTO getBankByCustomerBankId(@PathVariable("customerBankId") String customerBankId);
}
