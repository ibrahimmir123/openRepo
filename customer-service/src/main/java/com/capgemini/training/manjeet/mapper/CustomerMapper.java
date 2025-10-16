package com.capgemini.training.manjeet.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.training.manjeet.dto.CustomerRequestDTO;
import com.capgemini.training.manjeet.dto.CustomerResponseDTO;
import com.capgemini.training.manjeet.model.Customer;



/**
 * @Author Manjeet Kumar
 *  02-Sept-2025
 */
public class CustomerMapper {

	public static List<CustomerResponseDTO> convertToListOfResponseDTO(List<Customer> customers) {
		return customers.stream()
		.map(customer-> new CustomerResponseDTO(customer.getCustomerId(),customer.getName(),
				customer.getEmail())).collect(Collectors.toList());
	}
	
	public static CustomerResponseDTO convertToResponseDTO(Customer customer) {
		CustomerResponseDTO customerResponseDTO =new CustomerResponseDTO();
		customerResponseDTO.setCustomerId(customer.getCustomerId());
		customerResponseDTO.setEmail(customer.getEmail());
		customerResponseDTO.setName(customer.getName());
		return customerResponseDTO;
		
	}
	
	public static Customer convertToEntity(CustomerRequestDTO dto) {
		Customer customer=new Customer();
		customer.setName(dto.getName());
		customer.setDob(dto.getDob());
		customer.setGender(dto.getGender());
		customer.setAddress(dto.getAddress());
		customer.setMobileNo(dto.getMobileNo());
		customer.setEmail(dto.getEmail());
		return customer;
	}
}

