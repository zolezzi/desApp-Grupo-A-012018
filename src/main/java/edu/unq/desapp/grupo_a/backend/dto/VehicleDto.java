package edu.unq.desapp.grupo_a.backend.dto;

public class VehicleDto {
	
	public Long id;
	
	/**
	 * Ver que es mejor si usar Dto o solo los id, me parece que la primera opcion es mejor
	 * 
	 * */
	
	public UserDto userDto;
	
	public VehicleDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

}
