package edu.unq.desapp.grupo_a.backend.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="List")
public class RegisterDto {
	
    public List<VehicleDto> vehiclesDtos;

	public RegisterDto() {
		
	}

	public List<VehicleDto> getVehiclesDtos() {
		return vehiclesDtos;
	}

	public void setVehiclesDtos(List<VehicleDto> vehiclesDtos) {
		this.vehiclesDtos = vehiclesDtos;
	}


}
