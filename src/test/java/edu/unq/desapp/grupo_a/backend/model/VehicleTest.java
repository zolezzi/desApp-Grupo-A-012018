package edu.unq.desapp.grupo_a.backend.model;

import edu.unq.desapp.grupo_a.backend.model.builders.VehicleBuilder;
import edu.unq.desapp.grupo_a.backend.model.exceptions.VehicleDataException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

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
