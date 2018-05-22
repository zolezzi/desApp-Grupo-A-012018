package edu.unq.desapp.grupo_a.backend.model.builders;

import edu.unq.desapp.grupo_a.backend.model.Publication;
import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.model.Vehicle;

public class PublicationBuilder {

	private Vehicle vehicle = VehicleBuilder.aVehicle().build();
	private User offerent = UserBuilder.anUser().build();

	public static PublicationBuilder anOffer() {
		return new PublicationBuilder();
	}
	
	public Publication build() {
		
		Publication offer = new Publication(offerent, vehicle);
		return offer;
	}

	public PublicationBuilder withOfferent(User anOfferent) {
		offerent = anOfferent;
		return this;
	}

	public PublicationBuilder withVehicle(Vehicle aVehicle) {
		vehicle = aVehicle;
		return this;
	}
	
	public PublicationBuilder addVehicle() {
		offerent.addVehicle(vehicle);
		return this;
	}
}
