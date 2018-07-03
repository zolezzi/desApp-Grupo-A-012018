package edu.unq.desapp.grupo_a.backend.model;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import edu.unq.desapp.grupo_a.backend.model.builders.VehicleBuilder;
import edu.unq.desapp.grupo_a.backend.model.exceptions.VehicleDataException;

public class VehicleTest {

	@Test
	public void testVehicleWithValidVehicleData() {
		Vehicle aVehicle = VehicleBuilder.aVehicle()
				.withVehicleType(VehicleType.Moto)
				.withPassengerCapability(2)
				.withCity(new City())
				.withVehicleDescription("Moto de prueba para testVehicleWithValidVehicleData")
				.withPhotos(new ArrayList<>())
				.build();
		assertEquals(aVehicle.getVehicleType(), VehicleType.Moto);
	}
	
	@Test (expected = VehicleDataException.class)
	public void testVehicleWithNullVehicleType() {
		VehicleBuilder.aVehicle()
				.withVehicleType(null)
				.build();
	}

	@Test (expected = VehicleDataException.class)
	public void testVehicleWithZeroPassengerCapability() {
		VehicleBuilder.aVehicle()
				.withPassengerCapability(0)
				.build();
	}
	
	@Test (expected = VehicleDataException.class)
	public void testVehicleWithNullVehicleDescription() {
		VehicleBuilder.aVehicle()
				.withVehicleDescription(null)
				.build();
	}
	
	@Test (expected = VehicleDataException.class)
	public void testVehicleWithEmptyVehicleDescription() {
		VehicleBuilder.aVehicle()
				.withVehicleDescription("")
				.build();
	}
	
	@Test (expected = VehicleDataException.class)
	public void testVehicleWithBlankVehicleDescription() {
		VehicleBuilder.aVehicle()
				.withVehicleDescription("   ")
				.build();
	}

	@Test (expected = VehicleDataException.class)
	public void testVehicleWithNullPhotos() {
		VehicleBuilder.aVehicle()
				.withPhotos(null)
				.build();
	}
	
	@Test (expected = VehicleDataException.class)
	public void testVehicleWithInvalidPhotos() {
		List<Photo> photos = new ArrayList<>();
		photos.add(null);
		VehicleBuilder.aVehicle()
				.build();
	}
}
