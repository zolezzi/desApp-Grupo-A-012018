package edu.unq.desapp.grupo_a.backend.model.builders;

import java.util.ArrayList;
import java.util.List;

import edu.unq.desapp.grupo_a.backend.model.City;
import edu.unq.desapp.grupo_a.backend.model.Photo;
import edu.unq.desapp.grupo_a.backend.model.Vehicle;
import edu.unq.desapp.grupo_a.backend.model.VehicleType;

public class VehicleBuilder {

	private VehicleType vehicleType = VehicleType.Car;
	private int passengerCapability = 4;
	private City city = new City();
	private String vehicleDescription = "no description";
	private List<Photo> photos = new ArrayList<>();
	
	public static VehicleBuilder aVehicle() {
		return new VehicleBuilder();
	}
	
	public Vehicle build() {

		Vehicle vehicle = new Vehicle(vehicleType, passengerCapability,
				city, vehicleDescription, photos);
		return vehicle;
	}

	public VehicleBuilder withVehicleType(VehicleType aVehicleType) {
		vehicleType = aVehicleType;
		return this;
	}

	public VehicleBuilder withPassengerCapability(int aCapability) {
		passengerCapability = aCapability;
		return this;
	}

	public VehicleBuilder withCity(City aCity) {
		city = aCity;
		return this;
	}

	public VehicleBuilder withVehicleDescription(String aDescription) {
		vehicleDescription = aDescription;
		return this;
	}

	public VehicleBuilder withPhotos(List<Photo> somePhotos) {
		photos = somePhotos;
		return this;
	}
}
