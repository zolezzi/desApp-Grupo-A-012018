package edu.unq.desapp.grupo_a.backend.model;

import edu.unq.desapp.grupo_a.backend.model.builders.PublicationBuilder;
import edu.unq.desapp.grupo_a.backend.model.builders.UserBuilder;
import edu.unq.desapp.grupo_a.backend.model.builders.VehicleBuilder;
import edu.unq.desapp.grupo_a.backend.model.exceptions.WrongAddressException;
import edu.unq.desapp.grupo_a.backend.model.exceptions.WrongPublicationException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PublicationTest {

	@Test (expected = WrongPublicationException.class)
	public void testPublicationWithNullOfferent() {
		PublicationBuilder.aPublication()
			.withOfferent(null)
			.addVehicle()
			.build();
	}
	
	@Test (expected = WrongPublicationException.class)
	public void testPublicationWithNullVehicle() {
		PublicationBuilder.aPublication()
			.withVehicle(null)
			.addVehicle()
			.build();
	}
	
	@Test (expected = WrongPublicationException.class)
	public void testPublicationWithOfferentThatHasNotVehicle() {
		User anUser = UserBuilder.anUser().build();
		Vehicle aVehicle = VehicleBuilder.aVehicle().build();
		
		PublicationBuilder.aPublication()
			.withOfferent(anUser)
			.withVehicle(aVehicle)
			.build();
	}
	
	@Test (expected = WrongAddressException.class)
	public void testPublicationWithNullWithdrawAddress() {
		PublicationBuilder.aPublication()
			.addVehicle()
			.withWithdrawAddress(null)
			.build();
	}
	
	@Test (expected = WrongAddressException.class)
	public void testPublicationWithNullReturnAddresses() {
		PublicationBuilder.aPublication()
			.addVehicle()
			.withReturnAddresses(null)
			.build();
	}
	
	@Test (expected = WrongAddressException.class)
	public void testPublicationWithEmptyReturnAddresses() {
		List<Address> emptyAddresses = new ArrayList<Address>();
		
		PublicationBuilder.aPublication()
			.addVehicle()
			.withReturnAddresses(emptyAddresses)
			.build();
	}

	@Test (expected = WrongAddressException.class)
	public void testPublicationWithInvalidReturnAddresses() {
		List<Address> invalidAddresses = new ArrayList<Address>();
		invalidAddresses.add(null);
		
		PublicationBuilder.aPublication()
			.addVehicle()
			.withReturnAddresses(invalidAddresses)
			.build();
	}
	
	@Test (expected = WrongPublicationException.class)
	public void testPublicationWithNullAvailability() {
		PublicationBuilder.aPublication()
			.addVehicle()
			.withAvailability(null)
			.build();
	}
	
	@Test (expected = WrongPublicationException.class)
	public void testPublicationWithRentPriceZero() {
		PublicationBuilder.aPublication()
			.addVehicle()
			.withRentPrice(0)
			.build();
	}
}
