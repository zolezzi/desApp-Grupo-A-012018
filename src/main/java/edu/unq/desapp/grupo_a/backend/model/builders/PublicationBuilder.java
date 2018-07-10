package edu.unq.desapp.grupo_a.backend.model.builders;

import java.time.LocalDate;
import java.util.Date;

import edu.unq.desapp.grupo_a.backend.model.Address;
import edu.unq.desapp.grupo_a.backend.model.Publication;
import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.model.Vehicle;

public class PublicationBuilder extends Builder {

	private User offerent = (User) UserBuilder.anUser().build();
	private Vehicle vehicle = (Vehicle) VehicleBuilder.aVehicle().build();
	private Address withdrawAddress = AddressBuilder.anAddress().build();
	private Address returnAddresses = AddressBuilder.anAddress().build();
	private Date startingDate = new Date();
	private Date endingDate = new Date();
	private double rentPrice = 100;

	public static PublicationBuilder aPublication() {
		return new PublicationBuilder();
	}
	
	protected Publication fireBuild() {

		return new Publication(offerent, vehicle, withdrawAddress, returnAddresses, startingDate, endingDate, rentPrice);
	}

	public PublicationBuilder addVehicle() {
		if (offerent != null) {
			offerent.addVehicle(vehicle);
		}
		return this;
	}

	public PublicationBuilder withOfferent(User anOfferent) {
		offerent = anOfferent;
		return this;
	}

	public PublicationBuilder withVehicle(Vehicle aVehicle) {
		vehicle = aVehicle;
		return this;
	}

	public PublicationBuilder withWithdrawAddress(Address anAddress) {
		withdrawAddress = anAddress;
		return this;
	}

	public PublicationBuilder withReturnAddresses(Address someAddress) {
		returnAddresses = someAddress;
		return this;
	}

	public PublicationBuilder withStartingDate(Date aDate) {
		startingDate = aDate;
		return this;
	}

	public PublicationBuilder withRentPrice(double aPrice) {
		rentPrice  = aPrice;
		return this;
	}

	public PublicationBuilder withEndingDate(Date aDate) {
		endingDate = aDate;
		return this;
	}
}
