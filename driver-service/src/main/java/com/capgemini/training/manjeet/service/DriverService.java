package com.capgemini.training.manjeet.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.training.manjeet.dto.DriverRequestDTO;
import com.capgemini.training.manjeet.model.Driver;
import com.capgemini.training.manjeet.repository.DriverRepository;

/**
 * @Author Manjeet Kumar
 *  03-Sept-2025
 */

@Service
public class DriverService {

	@Autowired
    private DriverRepository driverRepository;

    public Driver addDriverDetails(Driver driver) {
        return driverRepository.save(driver);
    }

    public Optional<List<Driver>> getAllDriversDetails() { 
        return Optional.ofNullable(driverRepository.findAll()).filter(list -> !list.isEmpty());
    }

    public Optional<Driver> getDriverDetailsByDriverId(Long driverId) {
    	return driverRepository.findById(driverId);
    }

    public Driver updateDriverDetails(Long driverId, Driver driver) {
        Driver getDriverDetails = driverRepository.findById(driverId).orElseThrow(() -> new RuntimeException("Driver not found.."));
        getDriverDetails.setName(driver.getName());
        getDriverDetails.setAddress(driver.getAddress());
        getDriverDetails.setContactNo(driver.getContactNo());
        getDriverDetails.setLicenseNo(driver.getLicenseNo());
        return driverRepository.save(driver);
    }

    public void deleteDriverDetails(Long driverId) {
    	driverRepository.deleteById(driverId);
    }
}

