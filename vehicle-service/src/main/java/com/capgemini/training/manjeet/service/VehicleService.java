package com.capgemini.training.manjeet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.training.manjeet.model.Vehicle;
import com.capgemini.training.manjeet.repository.VehicleRepository;

/**
 * @Author Manjeet Kumar
 *  25-Jul-2025
 */

@Service
public class VehicleService {

	@Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
        
    }

    public Optional<List<Vehicle>> getAllVehicles() {
    	List<Vehicle> vehicles = vehicleRepository.findAll();
		return vehicles.isEmpty() ? Optional.empty() : Optional.of(vehicles);
    }

    public Optional<Vehicle> getVehicleByvehicleId(Long vehicleId) {
        return vehicleRepository.findById(vehicleId);
        
    }

    public Vehicle updateVehicleDetails(Long vehicleNo, Vehicle vehicle) {
        Vehicle getVehicle = vehicleRepository.findById(vehicleNo).orElseThrow(() -> new RuntimeException("Vehicle not found !!!"));
        getVehicle.setVehicleNo(vehicle.getVehicleNo());
        getVehicle.setVehicleName(vehicle.getVehicleName());
        getVehicle.setSeatingCapacity(vehicle.getSeatingCapacity());
        getVehicle.setVehicleType(vehicle.getVehicleType());
        getVehicle.setFarePerKm(vehicle.getFarePerKm());
        return vehicleRepository.save(getVehicle);
        
    }

    public void deleteVehicle(Long vehicleId) {
    	vehicleRepository.deleteById(vehicleId);
    }
}

