package edu.unq.desapp.grupo_a.backend.model.builders;

import edu.unq.desapp.grupo_a.backend.model.Publication;
import edu.unq.desapp.grupo_a.backend.model.Rent;

public class RentBuilder {

	private Publication publication = PublicationBuilder.aPublication().addVehicle().build();
	private int returnAddressIndex = 0;
	
	public static RentBuilder aRent() {
		return new RentBuilder();
	}

	public Rent build() {
		return new Rent(publication, returnAddressIndex);
	}

	public RentBuilder fromPublication(Publication aPublication) {
		this.publication = aPublication;
		return this;
	}

	public RentBuilder withReturnAddressIndex(int anAddressIndex) {
		this.returnAddressIndex = anAddressIndex;
		return this;
	}
}
