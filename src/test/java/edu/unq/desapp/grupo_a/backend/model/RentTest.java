package edu.unq.desapp.grupo_a.backend.model;

import edu.unq.desapp.grupo_a.backend.model.builders.*;
import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidRentException;
import org.junit.Test;

import java.time.LocalDate;

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
		User vehicleOwner = (User) UserBuilder.anUser()
									.build();
		Publication aPublication = (Publication) PublicationBuilder.aPublication()
												.withOfferent(vehicleOwner)
												.addVehicle()
												.build();
		Rent aRent = (Rent) RentBuilder.aRent()
							.fromPublication(aPublication)
							.build();
		
		assertEquals(aRent.getVehicleOwner(), vehicleOwner);
	}
	
	@Test
	public void testRentFromPublicationHasSameVehicle() {
		Vehicle aVehicle = (Vehicle) VehicleBuilder.aVehicle()
									.build();
		Publication aPublication = (Publication) PublicationBuilder.aPublication()
												.withVehicle(aVehicle)
												.addVehicle()
												.build();
		Rent aRent = (Rent) RentBuilder.aRent()
							.fromPublication(aPublication)
							.build();
		
		assertEquals(aRent.getVehicle(), aVehicle);
	}
	
	@Test
	public void testRentFromPublicationHasSameWithdrawAddress() {
		Address aWithdrawAddress = AddressBuilder.anAddress()
											.build();
		Publication aPublication = (Publication) PublicationBuilder.aPublication()
												.addVehicle()
												.withWithdrawAddress(aWithdrawAddress)
												.build();
		Rent aRent = (Rent) RentBuilder.aRent()
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
		Publication aPublication = (Publication) PublicationBuilder.aPublication()
												.addVehicle()
												.withRentPrice(aRentPrice)
												.build();
		Rent aRent = (Rent) RentBuilder.aRent()
							.fromPublication(aPublication)
							.build();

		assertTrue(aRent.getRentPrice() == aRentPrice);
	}

	@Test (expected = InvalidRentException.class)
	public void testRentWithSameVehicleOwnerAndRenter() {
		User anUser = (User) UserBuilder.anUser().build();
		Publication aPublication = (Publication) PublicationBuilder.aPublication()
												.withOfferent(anUser)
												.addVehicle()
												.build();
		RentBuilder.aRent()
				.fromPublication(aPublication)
				.withRenter(anUser)
				.build();
	}

	@Test (expected = InvalidRentException.class)
	public void testRentOfOldPublication() {
		Availability anOldAvailability = (Availability) AvailabilityBuilder.anAvailability()
												.withStartDate(LocalDate.now().minusDays(1))
												.withEndingDate(LocalDate.now().plusDays(2))
												.build();
		Publication aPublication = (Publication) PublicationBuilder.aPublication()
												.addVehicle()
												.withAvailability(anOldAvailability)
												.build();
		RentBuilder.aRent()
				.fromPublication(aPublication)
				.build();
	}
	
	@Test
	public void testRentHasSameStartingAndEndingDateAsPublication() {
		Availability anAvailability = (Availability) AvailabilityBuilder.anAvailability()
												.withStartDate(LocalDate.now().plusDays(1))
												.withEndingDate(LocalDate.now().plusDays(2))
												.build();
		Publication aPublication = (Publication) PublicationBuilder.aPublication()
												.addVehicle()
												.withAvailability(anAvailability)
												.build();
		Rent aRent = (Rent) RentBuilder.aRent()
							.fromPublication(aPublication)
							.build();

		assertEquals(anAvailability.getStartingDate(), aRent.getWithdrawDate());
		assertEquals(anAvailability.getEndingDate(), aRent.getReturnDate());
	}
}
