package edu.unq.desapp.grupo_a.backend.model.builders;

import edu.unq.desapp.grupo_a.backend.model.Publication;
import edu.unq.desapp.grupo_a.backend.model.Rent;
import edu.unq.desapp.grupo_a.backend.model.User;

public class RentBuilder {

	private Publication publication = PublicationBuilder.aPublication().addVehicle().build();
	private int returnAddressIndex = 0;
	private User renter = UserBuilder.anUser().build();

	public static RentBuilder aRent() {
		return new RentBuilder();
	}

	public Rent build() {
		return new Rent(publication, returnAddressIndex, renter);
	}

	public RentBuilder fromPublication(Publication aPublication) {
		this.publication = aPublication;
		return this;
	}

	public RentBuilder withReturnAddressIndex(int anAddressIndex) {
		this.returnAddressIndex = anAddressIndex;
		return this;
	}

	public RentBuilder withRenter(User anUser) {
		this.renter  = anUser;
		return this;
	}
}