package edu.unq.desapp.grupo_a.backend.model;

import edu.unq.desapp.grupo_a.backend.model.builders.VehicleBuilder;
import edu.unq.desapp.grupo_a.backend.model.exceptions.VehicleDataException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class VehicleTest {

	@Test
	public void testVehicleWithValidVehicleData() {
		Vehicle aVehicle = (Vehicle) VehicleBuilder.aVehicle()
				.withVehicleType(VehicleType.Moto)
				.withPassengerCapability(2)
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
}
