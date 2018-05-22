package edu.unq.desapp.grupo_a.backend.model.builders;

import edu.unq.desapp.grupo_a.backend.model.Availability;

public class AvailabilityBuilder {

	public static AvailabilityBuilder anAvailability() {
		return new AvailabilityBuilder();
	}

	public Availability build() {
		return new Availability();
	}
}
