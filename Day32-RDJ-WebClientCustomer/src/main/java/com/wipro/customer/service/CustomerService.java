package com.wipro.customer.service;

import com.wipro.customer.exception.ResourceNotFoundException;
import com.wipro.customer.DTO.APIResponseDTO;
import com.wipro.customer.DTO.BankDTO;
import com.wipro.customer.DTO.CustomerDTO;
import com.wipro.customer.DTO.VendorDTO;
import com.wipro.customer.model.Customer;
import com.wipro.customer.repository.CustomerRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RefreshScope
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private WebClient webClient;

    public Mono<Customer> addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Flux<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Mono<CustomerDTO> getCustomerById(int id) {
        return customerRepository.findById(id)
                .map(cust -> new CustomerDTO(cust.getCustomerId(), cust.getCustomerPhone(), cust.getCustomerBill(),
                        cust.getCustomerBankId(), cust.getCustomerStore()))
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Customer with ID " + id + " not found.")));
    }

    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "fallbackGetCustomerByBankId")
    @Retry(name = "${spring.application.name}", fallbackMethod = "fallbackGetCustomerByBankId")
    public Mono<APIResponseDTO> getCustomerByBankId(String bankId) {
        return customerRepository.findByCustomerBankId(bankId)
                .flatMap(cust -> {
                    // Fetch Bank details
                    return webClient.get()
                            .uri("http://server-bank:6061/bank/{customerBankId}", cust.getCustomerBankId())
                            .retrieve()
                            .bodyToMono(BankDTO.class)
                            .flatMap(bankDTO -> {
                                // Fetch Vendor details using vendor_name from BankDTO
                                return webClient.get()
                                        .uri("http://server-vendor:6062/vendor/{vendorAbbri}", bankDTO.getVendor_name())
                                        .retrieve()
                                        .bodyToMono(VendorDTO.class)
                                        .map(vendorDTO -> {
                                            // Convert Customer to DTO
                                            CustomerDTO custDTO = mapper.map(cust, CustomerDTO.class);

                                            // Populate APIResponseDTO
                                            APIResponseDTO apiResponseDto = new APIResponseDTO();
                                            apiResponseDto.setCustomerDTO(custDTO);
                                            apiResponseDto.setBankDTO(bankDTO);
                                            apiResponseDto.setVendorDTO(vendorDTO); // Include Vendor data

                                            return apiResponseDto;
                                        });
                            });
                })
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Customer with Account-ID " + bankId + " not found.")));
    }

    // Fallback method
    public Mono<APIResponseDTO> fallbackGetCustomerByBankId(String bankId, Throwable throwable) {
        BankDTO defaultBankDTO = new BankDTO();
        defaultBankDTO.setAccountId(0);
        defaultBankDTO.setHolder_name("Unknown");
        defaultBankDTO.setHolder_phone("N/A");
        defaultBankDTO.setBalance(0.0);
        defaultBankDTO.setVendor_name("Unknown");

        CustomerDTO defaultCustDTO = new CustomerDTO();

        VendorDTO defaultVendorDTO = new VendorDTO();
        defaultVendorDTO.setVendorId(0);
        defaultVendorDTO.setVendorName("Unknown");
        defaultVendorDTO.setVendorAbbri("N/A");

        APIResponseDTO apiResponseDto = new APIResponseDTO();
        apiResponseDto.setBankDTO(defaultBankDTO);
        apiResponseDto.setCustomerDTO(defaultCustDTO);
        apiResponseDto.setVendorDTO(defaultVendorDTO);

        return Mono.just(apiResponseDto);
    }

    public Flux<Customer> getCustomersByBillGreaterThan(double amount) {
        return customerRepository.findByCustomerBillGreaterThan(amount);
    }

    public Flux<Customer> getCustomersByBillLessThan(double amount) {
        return customerRepository.findByCustomerBillLessThan(amount);
    }

    public Mono<Customer> updateCustomer(int id, Customer updatedCustomer) {
        return customerRepository.findById(id)
                .flatMap(existingCustomer -> {
                    existingCustomer.setCustomerPhone(updatedCustomer.getCustomerPhone());
                    existingCustomer.setCustomerBill(updatedCustomer.getCustomerBill());
                    existingCustomer.setCustomerBankId(updatedCustomer.getCustomerBankId());
                    existingCustomer.setCustomerStore(updatedCustomer.getCustomerStore());
                    return customerRepository.save(existingCustomer);
                })
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Customer with ID " + id + " not found.")));
    }

    public Mono<Void> deleteCustomer(int id) {
        return customerRepository.existsById(id)
                .flatMap(exists -> {
                    if (!exists) {
                        return Mono.error(new ResourceNotFoundException("Customer with ID " + id + " not found."));
                    }
                    return customerRepository.deleteById(id);
                });
    }
}

/*
 * 
 * @CircuitBreaker(name="${spring.application.name}",fallbackMethod =
 * "getDefaultDepartment")
 * 
 * @Override public APIResponseDto getEmployeeById(Long employeeId) { // TODO
 * Auto-generated method stub Employee employee =
 * employeeRepository.findById(employeeId).get();
 * 
 * //ResponseEntity<DepartmentDto> responseEntity =
 * restTemplate.getForEntity("http://localhost:9090/departments/"+employee.
 * getDepartmentCode(), DepartmentDto.class);
 * 
 * 
 * //DepartmentDto departmentDto = responseEntity.getBody();
 * 
 * DepartmentDto departmentDto = webClient.get()
 * .uri("http://localhost:9090/departments/"+employee.getDepartmentCode())
 * .retrieve() .bodyToMono(DepartmentDto.class) .block();
 * 
 * 
 * //DepartmentDto departmentDto =
 * apiClient.getDepartmentByCode(employee.getDepartmentCode());
 * 
 * EmployeeDto employeeDto = mapper.map(employee, EmployeeDto.class);
 * 
 * APIResponseDto apiresponseDto = new APIResponseDto();
 * apiresponseDto.setDepartmentDto(departmentDto);
 * apiresponseDto.setEmployeeDto(employeeDto); return apiresponseDto;
 * 
 * }
 * 
 * 
 * public APIResponseDto getDefaultDepartment(Long employeeId, Exception
 * exception) { Employee employee =
 * employeeRepository.findById(employeeId).get();
 * 
 * DepartmentDto departmentDto = new DepartmentDto();
 * departmentDto.setDepartmentName("R&D Department");
 * departmentDto.setDepartmentCode("RD001");
 * departmentDto.setDepartmentDescription("Research and Development Department"
 * );
 * 
 * EmployeeDto employeeDto = mapper.map(employee, EmployeeDto.class);
 * APIResponseDto apiresponseDto = new APIResponseDto();
 * apiresponseDto.setDepartmentDto(departmentDto);
 * apiresponseDto.setEmployeeDto(employeeDto); return apiresponseDto;
 * 
 * }
 * 
 */
