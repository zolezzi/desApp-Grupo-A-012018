package edu.unq.desapp.grupo_a.backend.model;

import java.util.List;

public class VehicleData {
	
	private VehicleTypeEnum vehicleTypeEnum;
	
	private Integer passengerCapability;
	
	private City city;
	
	private Address withdrawInAddress;
	
	//review
	private String withdrawLocation;
	
	private List<Address> returnInAddress;
	
	private List<String> returnInLocation;
	
	private String vehicleDescription;
	
	private Phone contactPhone;
	
	private Boolean availability;
	
	private Double rentPrice;
	
	private List<Photo> photos;
}
