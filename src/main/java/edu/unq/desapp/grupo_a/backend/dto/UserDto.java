package edu.unq.desapp.grupo_a.backend.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDto {
	
	public Long id;
	
	public String name;
	
	public String lastName;

	public String cuil;
	
	public String email;
	
	public Integer reputation;
	
	public AddressDto address;
	
	public List<VehicleDto> vehicles = new ArrayList<>();
	
	public Double creditAmout; 
	
	public String idGoogle;
	
	public String idFacebook;
	
	public Boolean isRegister;
	
	public UserDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getReputation() {
		return reputation;
	}

	public void setReputation(Integer reputation) {
		this.reputation = reputation;
	}

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

	public List<VehicleDto> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<VehicleDto> vehicles) {
		this.vehicles = vehicles;
	}

	public Double getCreditAmout() {
		return creditAmout;
	}

	public void setCreditAmout(Double creditAmout) {
		this.creditAmout = creditAmout;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdGoogle() {
		return idGoogle;
	}

	public void setIdGoogle(String idGoogle) {
		this.idGoogle = idGoogle;
	}

	public String getIdFacebook() {
		return idFacebook;
	}

	public void setIdFacebook(String idFacebook) {
		this.idFacebook = idFacebook;
	}

	public Boolean getIsRegister() {
		return isRegister;
	}

	public void setIsRegister(Boolean isRegister) {
		this.isRegister = isRegister;
	}

}
