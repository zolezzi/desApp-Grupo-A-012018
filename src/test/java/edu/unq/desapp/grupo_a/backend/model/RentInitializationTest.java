package edu.unq.desapp.grupo_a.backend.model;

import edu.unq.desapp.grupo_a.backend.model.builders.*;
import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidAvailabilityException;
import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidRentException;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RentInitializationTest {

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

	@Test (expected = InvalidAvailabilityException.class)
	public void testRentOfOldPublication() {
		Publication aPublication = (Publication) PublicationBuilder.aPublication()
												.addVehicle()
												.withStartingDate(java.sql.Date.valueOf(LocalDate.now().minusDays(1)))
												.withEndingDate(java.sql.Date.valueOf(LocalDate.now().plusDays(2)))
												.build();
		RentBuilder.aRent()
				.fromPublication(aPublication)
				.build();
	}
	
	@Test
	public void testRentHasSameStartingAndEndingDateAsPublication() {
		Publication aPublication = (Publication) PublicationBuilder.aPublication()
												.addVehicle()
												.withStartingDate(java.sql.Date.valueOf(LocalDate.now().plusDays(1)))
												.withEndingDate(java.sql.Date.valueOf(LocalDate.now().plusDays(2)))
												.build();
		Rent aRent = (Rent) RentBuilder.aRent()
							.fromPublication(aPublication)
							.build();

		assertEquals(aPublication.getStartingDate(), aRent.getWithdrawDate());
		assertEquals(aPublication.getEndingDate(), aRent.getReturnDate());
	}
}
