package com.capgemini.training.manjeet.dto;

import java.util.List;

/**
 * @Author Manjeet Kumar
 *  02-Sept-2025
 */
public class VehicleRequestDTO {

	   private String vehicleNo;
	    private String vehicleName;
	    private int seatingCapacity;
	    private String vehicleType;
	    private double farePerKm;
	    private List<DriverRequestDTO> drivers;
		/**
		 * 
		 */
		public VehicleRequestDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
		/**
		 * @param vehicleNo
		 * @param vehicleName
		 * @param seatingCapacity
		 * @param vehicleType
		 * @param farePerKm
		 * @param drivers
		 */
		public VehicleRequestDTO(String vehicleNo, String vehicleName, int seatingCapacity, String vehicleType,
				double farePerKm, List<DriverRequestDTO> drivers) {
			super();
			this.vehicleNo = vehicleNo;
			this.vehicleName = vehicleName;
			this.seatingCapacity = seatingCapacity;
			this.vehicleType = vehicleType;
			this.farePerKm = farePerKm;
			this.drivers = drivers;
		}
		/**
		 * @return the vehicleNo
		 */
		public String getVehicleNo() {
			return vehicleNo;
		}
		/**
		 * @param vehicleNo the vehicleNo to set
		 */
		public void setVehicleNo(String vehicleNo) {
			this.vehicleNo = vehicleNo;
		}
		/**
		 * @return the vehicleName
		 */
		public String getVehicleName() {
			return vehicleName;
		}
		/**
		 * @param vehicleName the vehicleName to set
		 */
		public void setVehicleName(String vehicleName) {
			this.vehicleName = vehicleName;
		}
		/**
		 * @return the seatingCapacity
		 */
		public int getSeatingCapacity() {
			return seatingCapacity;
		}
		/**
		 * @param seatingCapacity the seatingCapacity to set
		 */
		public void setSeatingCapacity(int seatingCapacity) {
			this.seatingCapacity = seatingCapacity;
		}
		/**
		 * @return the vehicleType
		 */
		public String getVehicleType() {
			return vehicleType;
		}
		/**
		 * @param vehicleType the vehicleType to set
		 */
		public void setVehicleType(String vehicleType) {
			this.vehicleType = vehicleType;
		}
		/**
		 * @return the farePerKm
		 */
		public double getFarePerKm() {
			return farePerKm;
		}
		/**
		 * @param farePerKm the farePerKm to set
		 */
		public void setFarePerKm(double farePerKm) {
			this.farePerKm = farePerKm;
		}
		/**
		 * @return the drivers
		 */
		public List<DriverRequestDTO> getDrivers() {
			return drivers;
		}
		/**
		 * @param drivers the drivers to set
		 */
		public void setDrivers(List<DriverRequestDTO> drivers) {
			this.drivers = drivers;
		}
		@Override
		public String toString() {
			return "VehicleRequestDTO [vehicleNo=" + vehicleNo + ", vehicleName=" + vehicleName + ", seatingCapacity="
					+ seatingCapacity + ", vehicleType=" + vehicleType + ", farePerKm=" + farePerKm + ", drivers="
					+ drivers + "]";
		}
		
	    
	    
	    
}

