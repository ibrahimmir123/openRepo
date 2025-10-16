package com.capgemini.training.manjeet.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.training.manjeet.dto.DriverResponseDTO;
import com.capgemini.training.manjeet.dto.VehicleRequestDTO;
import com.capgemini.training.manjeet.dto.VehicleResponseDTO;
import com.capgemini.training.manjeet.model.Driver;
import com.capgemini.training.manjeet.model.Vehicle;

/**
 * @Author Manjeet Kumar 02-Sept-2025
 */
public class VehicleMapper {

	public static List<VehicleResponseDTO> convertToListOfResponseDTO(List<Vehicle> vehicles) {
		return vehicles.stream().map(vehicle -> new VehicleResponseDTO(vehicle.getVehicleId(), vehicle.getVehicleNo(),
				vehicle.getVehicleName(), vehicle.getSeatingCapacity(), vehicle.getVehicleType(),
				vehicle.getFarePerKm(),
				vehicle.getDrivers().stream().map(
						driver -> new DriverResponseDTO(driver.getDriverId(), driver.getName(), driver.getLicenseNo()))
						.collect(Collectors.toList())))
				.collect(Collectors.toList());

	}

	public static VehicleResponseDTO convertToResponseDTO(Vehicle vehicle) {

		VehicleResponseDTO vehicleResponseDTO = new VehicleResponseDTO();
		vehicleResponseDTO.setVehicleId(vehicle.getVehicleId());
		vehicleResponseDTO.setVehicleNo(vehicle.getVehicleNo());
		vehicleResponseDTO.setVehicleName(vehicle.getVehicleName());
		vehicleResponseDTO.setVehicleType(vehicle.getVehicleType());
		vehicleResponseDTO.setSeatingCapacity(vehicle.getSeatingCapacity());
		vehicleResponseDTO.setFarePerKm(vehicle.getFarePerKm());

		// Map drivers to DriverResponseDTO
		if (vehicle.getDrivers() != null) {
			List<DriverResponseDTO> driverDTOs = vehicle.getDrivers().stream().map(driver -> {
				DriverResponseDTO dto = new DriverResponseDTO();
				dto.setDriverId(driver.getDriverId());
				dto.setName(driver.getName());
				dto.setLicenseNo(driver.getLicenseNo());
				return dto;
			}).collect(Collectors.toList());

			vehicleResponseDTO.setDrivers(driverDTOs);
		}

		return vehicleResponseDTO;

	}

	public static Vehicle convertToEntity(VehicleRequestDTO dto) {

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleNo(dto.getVehicleNo());
		vehicle.setVehicleName(dto.getVehicleName());
		vehicle.setSeatingCapacity(dto.getSeatingCapacity());
		vehicle.setVehicleType(dto.getVehicleType());
		vehicle.setFarePerKm(dto.getFarePerKm());

		if (dto.getDrivers() != null) {
			List<Driver> drivers = dto.getDrivers().stream().map(driverDto -> {
				Driver driver = new Driver();
				driver.setName(driverDto.getName());
				driver.setLicenseNo(driverDto.getLicenseNo());
				driver.setVehicle(vehicle); 
				return driver;
			}).collect(Collectors.toList());

			vehicle.setDrivers(drivers);
		}

		return vehicle;

	}
}
