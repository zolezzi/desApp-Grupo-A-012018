package edu.unq.desapp.grupo_a.backend.dto;

public class VehicleFilterDto {
	
	
	String patent;
	
	String model;
	
	String brand;
	
	String vehicleType;
	
	Long userId;

	public String getPatent() {
		return patent;
	}

	public void setPatent(String patent) {
		this.patent = patent;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
