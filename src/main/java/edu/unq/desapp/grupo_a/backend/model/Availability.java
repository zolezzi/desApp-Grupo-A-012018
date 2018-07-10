package edu.unq.desapp.grupo_a.backend.model;

import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidAvailabilityException;

import java.time.LocalDate;

public class Availability {

    private Availability(){

    }

	public static void check(Publication publication)
			throws InvalidAvailabilityException {
//		LocalDate now = LocalDate.now();
//		if (publication.getStartingDate() != null && publication.getStartingDate().isBefore(now)) {
//			throw new InvalidAvailabilityException();
//		}
	}
}
