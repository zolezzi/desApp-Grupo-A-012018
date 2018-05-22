package edu.unq.desapp.grupo_a.backend.model;

import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidAvailabilityException;

public class Availability {

	public static void check(Availability availability) throws InvalidAvailabilityException {
		if (availability == null) {
			throw new InvalidAvailabilityException();
		}
	}
}
