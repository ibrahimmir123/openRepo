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
import com.capgemini.training.manjeet.dto.VehicleRequestDTO;
import com.capgemini.training.manjeet.dto.VehicleResponseDTO;
import com.capgemini.training.manjeet.mapper.VehicleMapper;
import com.capgemini.training.manjeet.model.Vehicle;
import com.capgemini.training.manjeet.service.VehicleService;
import com.capgemini.training.manjeet.util.ResponseBuilder;


/**
 * @Author Manjeet Kumar
 *  25-Jul-2025
 */

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {

	private static final Logger logger=LoggerFactory.getLogger(VehicleController.class);
	
	@Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<ApiResponse<VehicleResponseDTO>> addVehicle(@RequestBody VehicleRequestDTO requestDTO) {
    	logger.info("Creating new Vehicle..");
		try {
    	Vehicle vehicleRegistration = vehicleService.addVehicle(VehicleMapper.convertToEntity(requestDTO));
    	return ResponseBuilder.created(VehicleMapper.convertToResponseDTO(vehicleRegistration),
				"Vehicle Created Successfully !!");
	} catch (RuntimeException e) {
		logger.error("Vehicle creation fail",e);
		return ResponseBuilder.error(HttpStatus.INTERNAL_SERVER_ERROR, "Getting Error : " + e.getMessage());
	}
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<VehicleResponseDTO>>> getAllVehicles() {
    	logger.info("Fetching all Vehicle details...");
         return vehicleService.getAllVehicles().map(allVehicles -> ResponseBuilder.success(
        		 VehicleMapper.convertToListOfResponseDTO(allVehicles),
	                "Vehicle Details Fetch Successfully !!"))
	        .orElse(ResponseBuilder.error(HttpStatus.NOT_FOUND, "Customer not found"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<VehicleResponseDTO>> getVehicleByvehicleId(@PathVariable Long vehicleId) {
        return vehicleService.getVehicleByvehicleId(vehicleId)
        		.map(vehicle -> ResponseBuilder.success(VehicleMapper.convertToResponseDTO(vehicle),
				"vehicle Details Fetch Successfully !!"))
		.orElse(ResponseBuilder.error(HttpStatus.NOT_FOUND, "vehicle not found with vehicleID: " + vehicleId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<VehicleResponseDTO>> updateVehicleDetails(@PathVariable Long vehicleId, @RequestBody VehicleRequestDTO requestDTO) {
    	logger.info("Updation Vehicle details..");
		try {
    	 Vehicle updatedVehicleDetails = vehicleService.updateVehicleDetails(vehicleId, VehicleMapper.convertToEntity(requestDTO));
    	 return ResponseBuilder.success(VehicleMapper.convertToResponseDTO(updatedVehicleDetails),
					"Vehicle Details updated Successfully !!");
		} catch (RuntimeException e) {
			logger.error("Vehicle details updation fail..",e);
			return ResponseBuilder.error(HttpStatus.NOT_FOUND, "Getting Error : " + e.getMessage());
		}
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long vehicleId) {
    	vehicleService.deleteVehicle(vehicleId);
        return ResponseEntity.noContent().build();
    }
}

