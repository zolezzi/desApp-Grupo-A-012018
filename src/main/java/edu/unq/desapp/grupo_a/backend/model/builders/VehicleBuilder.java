package edu.unq.desapp.grupo_a.backend.model.builders;

import edu.unq.desapp.grupo_a.backend.model.Photo;
import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.model.Vehicle;
import edu.unq.desapp.grupo_a.backend.model.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class VehicleBuilder extends Builder {

	private VehicleType vehicleType = VehicleType.Car;
	private int passengerCapability = 4;
	private String vehicleDescription = "no description";
	private List<String> photos = new ArrayList<>();
	
	public static VehicleBuilder aVehicle() {
		return new VehicleBuilder();
	}
	
	@Override
	protected Vehicle fireBuild() {
		return new Vehicle(vehicleType, passengerCapability, vehicleDescription, photos);
	}

	public VehicleBuilder withVehicleType(VehicleType aVehicleType) {
		vehicleType = aVehicleType;
		return this;
	}

	public VehicleBuilder withPassengerCapability(int aCapability) {
		passengerCapability = aCapability;
		return this;
	}

	public VehicleBuilder withVehicleDescription(String aDescription) {
		vehicleDescription = aDescription;
		return this;
	}

	public VehicleBuilder withPhotos(List<String> somePhotos) {
		photos = somePhotos;
		return this;
	}
}
