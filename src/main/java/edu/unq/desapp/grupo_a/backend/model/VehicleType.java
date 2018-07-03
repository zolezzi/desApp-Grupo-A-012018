package edu.unq.desapp.grupo_a.backend.model;

import edu.unq.desapp.grupo_a.backend.dto.VehicleTypeDto;
import edu.unq.desapp.grupo_a.backend.model.exceptions.VehicleDataException;

/**
 * @author Carlos Cardozo
 *
 */
public enum VehicleType {
	Car("Car", "vehicle.type.car"),
	Moto("Moto", "vehicle.type.moto"),
	PickUp("PickUp", "vehicle.type.pickup");
	
	String description;
	String i18nCode;

	private VehicleType() {
		
	}
	
	private VehicleType(String description, String i18nCode) {
		this.description = description;
		this.i18nCode = i18nCode;
	}

	public String getDescription() {
		return description;
	}
	
	public String getI18nCode() {
		return i18nCode;
	}

	public static void check(VehicleType vehicleType) throws VehicleDataException {
		if (vehicleType == null) {
			throw new VehicleDataException();
		}
	}
	
	public VehicleTypeDto toDto(){
		
		VehicleTypeDto vehicleTypeDto = new VehicleTypeDto();
		vehicleTypeDto.setDescription(description);
		vehicleTypeDto.setI18nCode(i18nCode);
		
		return vehicleTypeDto;
	}
}
