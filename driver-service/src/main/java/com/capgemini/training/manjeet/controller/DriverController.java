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
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.manjeet.dto.ApiResponse;
import com.capgemini.training.manjeet.dto.DriverRequestDTO;
import com.capgemini.training.manjeet.dto.DriverResponseDTO;
import com.capgemini.training.manjeet.mapper.DriverMapper;
import com.capgemini.training.manjeet.model.Driver;
import com.capgemini.training.manjeet.service.DriverService;
import com.capgemini.training.manjeet.util.ResponseBuilder;

/**
 * @Author Manjeet Kumar 25-Jul-2025
 */

@RestController
@RequestMapping("/api/v1/drivers")
public class DriverController {

	private static final Logger logger = LoggerFactory.getLogger(DriverController.class);

	@Autowired
	private DriverService driverService;

	@PostMapping
	public ResponseEntity<ApiResponse<DriverResponseDTO>> addDriverDetails(@RequestBody DriverRequestDTO requestDTO) {
		logger.info("Creating new Driver ..");
		try {
			Driver driverDetailsRegistration = driverService.addDriverDetails(DriverMapper.convertToEntity(requestDTO));
			return ResponseBuilder.created(DriverMapper.convertToResponseDTO(driverDetailsRegistration),
					"Driver Created Successfully !!");
		} catch (RuntimeException e) {
			logger.error("Driver creation fail {}", e);
			return ResponseBuilder.error(HttpStatus.INTERNAL_SERVER_ERROR, "Getting Error : " + e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<ApiResponse<List<DriverResponseDTO>>> getAllDrivers() {
		logger.info("Fetching all Driver details...");
		return driverService.getAllDriversDetails()
				.map(allDrivers -> ResponseBuilder.success(DriverMapper.convertToListOfResponseDTO(allDrivers),
						"Driver Details Fetch Successfully !!"))
				.orElse(ResponseBuilder.error(HttpStatus.NOT_FOUND, "Driver not found"));
	}

	@GetMapping("/<built-in function id>")
	public ResponseEntity<ApiResponse<DriverResponseDTO>> getDriverByDriverId(@PathVariable Long driverId) {
		logger.info("Fetching Driver details by driverId..");
		return driverService.getDriverDetailsByDriverId(driverId)
				.map(driver -> ResponseBuilder.success(DriverMapper.convertToResponseDTO(driver),
						"Driver Details Fetch Successfully !!"))
				.orElse(ResponseBuilder.error(HttpStatus.NOT_FOUND, "Driver not found with driverID: " + driverId));
	}

	@PutMapping("/<built-in function id>")
	public ResponseEntity<ApiResponse<DriverResponseDTO>> updateDriverDetails(@PathVariable Long driverId,
			@RequestBody DriverRequestDTO requestDTO) {
		logger.info("Updation Driver details..");
		try {
			Driver updatedDriverDetails = driverService.updateDriverDetails(driverId,
					DriverMapper.convertToEntity(requestDTO));
			return ResponseBuilder.success(DriverMapper.convertToResponseDTO(updatedDriverDetails),
					"Driver Details updated Successfully !!");
		} catch (RuntimeException e) {
			logger.error("Driver details updation fail {}", e);
			return ResponseBuilder.error(HttpStatus.NOT_FOUND, "Getting Error : " + e.getMessage());
		}

	}

	@DeleteMapping("/<built-in function id>")
	public ResponseEntity<Void> deleteDriver(@PathVariable Long Driver) {
		driverService.deleteDriverDetails(Driver);
		return ResponseEntity.noContent().build();
	}

}
