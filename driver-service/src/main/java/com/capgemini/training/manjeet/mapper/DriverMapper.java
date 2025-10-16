package com.capgemini.training.manjeet.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.training.manjeet.dto.DriverRequestDTO;
import com.capgemini.training.manjeet.dto.DriverResponseDTO;
import com.capgemini.training.manjeet.model.Driver;

/**
 * @Author Manjeet Kumar
 *  02-Sept-2025
 */
public class DriverMapper {

	public static List<DriverResponseDTO> convertToListOfResponseDTO(List<Driver> drivers) {
		return drivers.stream()
		.map(driver-> new DriverResponseDTO(driver.getDriverId(),driver.getName(),
				driver.getContactNo())).collect(Collectors.toList());
	}
	
	public static DriverResponseDTO convertToResponseDTO(Driver driver) {
		DriverResponseDTO driverResponseDTO =new DriverResponseDTO();
		driverResponseDTO.setDriverId(driver.getDriverId());
		driverResponseDTO.setName(driver.getName());
		driverResponseDTO.setContactNo(driver.getContactNo());
		return driverResponseDTO;
		
	}
	
	public static Driver convertToEntity(DriverRequestDTO dto) {
		Driver driver=new Driver();
		driver.setName(dto.getName());
		driver.setAddress(dto.getAddress());
		driver.setContactNo(dto.getContactNo());
		driver.setLicenseNo(dto.getLicenseNo());
		return driver;
	}
}

