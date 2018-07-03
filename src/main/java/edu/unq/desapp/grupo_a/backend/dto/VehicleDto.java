package edu.unq.desapp.grupo_a.backend.dto;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class VehicleDto {
	
	public Long id;
	
	/**
	 * Ver que es mejor si usar Dto o solo los id, me parece que la primera opcion es mejor
	 * 
	 * */
	
	public String userName;
	
	public Long userId;
	
    private Integer passengerCapability;

    private String vehicleDescription;
    
    private String model;
    
    private String brand;

    private String patent;
    
    private String vehicleType;

    private List<String> photos;
	
	//public UserDto userDto;
	
	public VehicleDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public UserDto getUserDto() {
//		return userDto;
//	}
//
//	public void setUserDto(UserDto userDto) {
//		this.userDto = userDto;
//	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getPassengerCapability() {
		return passengerCapability;
	}

	public void setPassengerCapability(Integer passengerCapability) {
		this.passengerCapability = passengerCapability;
	}

	public String getVehicleDescription() {
		return vehicleDescription;
	}

	public void setVehicleDescription(String vehicleDescription) {
		this.vehicleDescription = vehicleDescription;
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

	public String getPatent() {
		return patent;
	}

	public void setPatent(String patent) {
		this.patent = patent;
	}

	public List<String> getPhotos() {
		return photos;
	}

	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

}
