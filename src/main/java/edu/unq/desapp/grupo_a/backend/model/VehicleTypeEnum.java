package edu.unq.desapp.grupo_a.backend.model;

/**
 * @author Carlos Cardozo
 *
 */
public enum VehicleTypeEnum {
	Car("Car", "vehicle.type.car");
	
	private VehicleTypeEnum() {
		
	}
	
	private VehicleTypeEnum(String description, String i18nCode) {
		this.description = description;
		this.i18nCode = i18nCode;
	}

	String description;
	
	String i18nCode;

	public String getDescription() {
		return description;
	}
	
	public String getI18nCode() {
		return i18nCode;
	}

}



