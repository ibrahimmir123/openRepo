package com.capgemini.training.manjeet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.training.manjeet.model.Customer;
import com.capgemini.training.manjeet.repository.CustomerRepository;

/**
 * @Author Manjeet Kumar
 *  02-Sept-2025
 */

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	
	public Customer customerRegistration(Customer customer) {
		 return customerRepository.save(customer);
	
	}
	
	public Optional<Customer> getCustomerDetailsBycustomerId(Long customerId){
		  return customerRepository.findById(customerId);
		//return customerRepository.getReferenceById(customerId);
	}
	
	public Optional<Customer> getCustomerDetailsByEmailId(String email) {
		System.out.println("email : "+email);
		return customerRepository.findCustomerByEmail(email);
	}

	public Optional<List<Customer>> getAllCustomerDetails() {
		return Optional.ofNullable(customerRepository.findAll()).filter(list -> !list.isEmpty());
}

	public Customer updateCustomerDetails(Long customerId,Customer customer){
	Customer getCustomer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
	getCustomer.setName(customer.getName());
	getCustomer.setDob(customer.getDob());
	getCustomer.setGender(customer.getGender());
	getCustomer.setAddress(customer.getAddress());
	getCustomer.setMobileNo(customer.getMobileNo());
	getCustomer.setEmail(customer.getEmail());
	
	 return customerRepository.save(getCustomer);
	
	}
	
	public void deleteCustomerDetails(Long customerId){
		  customerRepository.deleteById(customerId);
		 
	}
	
	
}

