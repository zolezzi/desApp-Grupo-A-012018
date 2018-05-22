package edu.unq.desapp.grupo_a.backend.model;

import edu.unq.desapp.grupo_a.backend.model.builders.*;
import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidRentException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RentTest {

	@Test (expected = InvalidRentException.class)
	public void testRentFromNullPublication() {
		RentBuilder.aRent()
				.fromPublication(null)
				.build();
	}
	
	@Test
	public void testRentFromPublicationHasSameVehicleOwner() {
		User vehicleOwner = UserBuilder.anUser()
									.build();
		Publication aPublication = PublicationBuilder.aPublication()
												.withOfferent(vehicleOwner)
												.addVehicle()
												.build();
		Rent aRent = RentBuilder.aRent()
							.fromPublication(aPublication)
							.build();
		
		assertEquals(aRent.getVehicleOwner(), vehicleOwner);
	}
	
	@Test
	public void testRentFromPublicationHasSameVehicle() {
		Vehicle aVehicle = VehicleBuilder.aVehicle()
									.build();
		Publication aPublication = PublicationBuilder.aPublication()
												.withVehicle(aVehicle)
												.addVehicle()
												.build();
		Rent aRent = RentBuilder.aRent()
							.fromPublication(aPublication)
							.build();
		
		assertEquals(aRent.getVehicle(), aVehicle);
	}
	
	@Test
	public void testRentFromPublicationHasSameWithdrawAddress() {
		Address aWithdrawAddress = AddressBuilder.anAddress()
											.build();
		Publication aPublication = PublicationBuilder.aPublication()
												.addVehicle()
												.withWithdrawAddress(aWithdrawAddress)
												.build();
		Rent aRent = RentBuilder.aRent()
				.fromPublication(aPublication)
				.build();

		assertEquals(aRent.getWithdrawAddress(), aWithdrawAddress);
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testRentWithInvalidReturnAddressIndex() {
		RentBuilder.aRent()
				.withReturnAddressIndex(-1)
				.build();
	}
	
	@Test
	public void testRentFromPublicationHasSameRentPrice() {
		double aRentPrice = 500;
		Publication aPublication = PublicationBuilder.aPublication()
												.addVehicle()
												.withRentPrice(aRentPrice)
												.build();
		Rent aRent = RentBuilder.aRent()
							.fromPublication(aPublication)
							.build();

		assertTrue(aRent.getRentPrice() == aRentPrice);
	}

	@Test (expected = InvalidRentException.class)
	public void testRentWithSameVehicleOwnerAndRenter() {
		User anUser = UserBuilder.anUser().build();
		Publication aPublication = PublicationBuilder.aPublication()
												.withOfferent(anUser)
												.addVehicle()
												.build();
		RentBuilder.aRent()
				.fromPublication(aPublication)
				.withRenter(anUser)
				.build();
	}
}
