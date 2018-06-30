package edu.unq.desapp.grupo_a.backend.model;

import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidAvailabilityException;
import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidRentException;

import java.time.LocalDate;

public class Availability extends PersistenceEntity {

	private LocalDate startingDate;
	private LocalDate endingDate;

	public Availability (LocalDate startingDate, LocalDate endingDate)
			throws InvalidAvailabilityException {

		this.startingDate = startingDate;
		this.endingDate = endingDate;
	}

	public static void check(Publication publication)
			throws InvalidRentException {
		LocalDate now = LocalDate.now();
		if (publication.getAvailability().getStartingDate().isBefore(now)) {
			throw new InvalidRentException();
		}
	}

	public LocalDate getStartingDate() {
		return this.startingDate;
	}

	public LocalDate getEndingDate() {
		return this.endingDate;
	}
}
