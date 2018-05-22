package edu.unq.desapp.grupo_a.backend.model;

import org.junit.Test;

import edu.unq.desapp.grupo_a.backend.model.builders.PublicationBuilder;
import edu.unq.desapp.grupo_a.backend.model.builders.UserBuilder;
import edu.unq.desapp.grupo_a.backend.model.builders.VehicleBuilder;
import edu.unq.desapp.grupo_a.backend.model.exceptions.WrongPublicationException;

public class PublicationTest {

	@Test (expected = WrongPublicationException.class)
	public void testPublicationWithNullOfferent() {
		PublicationBuilder.anOffer()
			.withOfferent(null)
			.build();
	}
	
	@Test (expected = WrongPublicationException.class)
	public void testPublicationWithNullVehicle() {
		PublicationBuilder.anOffer()
			.withVehicle(null)
			.build();
	}
	
	@Test (expected = WrongPublicationException.class)
	public void testPublicationWithOfferentThatHasNotVehicle() {
		User anUser = UserBuilder.anUser().build();
		Vehicle aVehicle = VehicleBuilder.aVehicle().build();
		
		PublicationBuilder.anOffer()
			.withOfferent(anUser)
			.withVehicle(aVehicle)
			.build();
	}
	
	@Test
	public void testPublicationWithOfferentThatHasVehicle() {
		User anUser = UserBuilder.anUser().build();
		Vehicle aVehicle = VehicleBuilder.aVehicle().build();
		anUser.addVehicle(aVehicle);
		
		PublicationBuilder.anOffer()
			.withOfferent(anUser)
			.withVehicle(aVehicle)
			.build();
	}
}
