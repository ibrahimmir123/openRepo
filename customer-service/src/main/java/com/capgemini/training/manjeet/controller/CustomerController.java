package com.capgemini.training.manjeet.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.manjeet.dto.ApiResponse;
import com.capgemini.training.manjeet.dto.CustomerRequestDTO;
import com.capgemini.training.manjeet.dto.CustomerResponseDTO;
import com.capgemini.training.manjeet.mapper.CustomerMapper;
import com.capgemini.training.manjeet.model.Customer;
import com.capgemini.training.manjeet.service.CustomerService;
import com.capgemini.training.manjeet.util.ResponseBuilder;

/**
 * @Author Manjeet Kumar
 *  03-Sept-2025
 */

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
	
	private static final Logger logger=LoggerFactory.getLogger(CustomerController.class);

	 @Autowired
	    private CustomerService customerService;

	    @PostMapping
	    public ResponseEntity<ApiResponse<CustomerResponseDTO>> customerRegistration(@RequestBody CustomerRequestDTO requestDTO) {
	    	logger.info("Creating new Customer..");
			try {
	    	Customer customerRegistration = customerService.customerRegistration(CustomerMapper.convertToEntity(requestDTO));
	        return ResponseBuilder.created(CustomerMapper.convertToResponseDTO(customerRegistration),
					"Customer Created Successfully !!");
		} catch (RuntimeException e) {
			logger.error("Customer creation fail",e);
			return ResponseBuilder.error(HttpStatus.INTERNAL_SERVER_ERROR, "Getting Error : " + e.getMessage());
		}
	    }
	    
	    @GetMapping
	    public ResponseEntity<ApiResponse<List<CustomerResponseDTO>>> getAllCustomerDetails() {
	    	logger.info("Fetching all Customer details..."); 
	    	return customerService.getAllCustomerDetails().map(allCustomers -> ResponseBuilder.success(
	                CustomerMapper.convertToListOfResponseDTO(allCustomers),
	                "Customer Details Fetch Successfully !!"))
	        .orElse(ResponseBuilder.error(HttpStatus.NOT_FOUND, "Customer not found"));
}

	    @GetMapping("/{customerId}")
	    public ResponseEntity<ApiResponse<CustomerResponseDTO>> getCustomerDetailsBycustomerId(@PathVariable Long customerId) {
	        logger.info("Fetching Customer details by customerId..");
			 return customerService.getCustomerDetailsBycustomerId(customerId).map(customer -> ResponseBuilder.success(CustomerMapper.convertToResponseDTO(customer),
							"Customer Details Fetch Successfully !!"))
					.orElse(ResponseBuilder.error(HttpStatus.NOT_FOUND, "Customer not found with CustomerID: " + customerId));
		}
	    

	    @GetMapping("/email")
	    public ResponseEntity<ApiResponse<CustomerResponseDTO>> getCustomerDetailsByEmailId(@RequestParam(required = true) String email) {
	    	logger.info("Fetching Customer details by email..");
			return customerService.getCustomerDetailsByEmailId(email)
					.map(customer -> ResponseBuilder.success(CustomerMapper.convertToResponseDTO(customer),
							"Customer Details Fetch Successfully !!"))
					.orElse(ResponseBuilder.error(HttpStatus.NOT_FOUND, "Customer not found with Email: " + email));
		}
	    

	    @PutMapping("/{id}")
	    public  ResponseEntity<ApiResponse<CustomerResponseDTO>> updateCustomerDetails(@PathVariable Long customerId, @RequestBody CustomerRequestDTO requestDTO) {
	    	logger.info("Updation Customer details..");
			try {
				Customer updateCustomer = customerService.updateCustomerDetails(customerId, CustomerMapper.convertToEntity(requestDTO));
				return ResponseBuilder.success(CustomerMapper.convertToResponseDTO(updateCustomer),
						"Customer Details updated Successfully !!");
			} catch (RuntimeException e) {
				logger.error("Customer details updation fail..",e);
				return ResponseBuilder.error(HttpStatus.NOT_FOUND, "Getting Error : " + e.getMessage());
			}
		}
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCustomerDetails(@PathVariable Long customerId) {
	    	customerService.deleteCustomerDetails(customerId);
	        return ResponseEntity.noContent().build();
	    }
	
	
}

