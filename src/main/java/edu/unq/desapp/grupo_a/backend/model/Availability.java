package edu.unq.desapp.grupo_a.backend.model;

import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidAvailabilityException;

import java.time.LocalDate;

public class Availability {

	private LocalDate aStartingDate;
	private LocalDate anEndingDate;

	public Availability (LocalDate aStartingDate, LocalDate anEndingDate)
			throws InvalidAvailabilityException {

		check (aStartingDate, anEndingDate);
		this.aStartingDate = aStartingDate;
		this.anEndingDate = anEndingDate;
	}

	private static void check(LocalDate aStartingDate, LocalDate anEndingDate)
			throws InvalidAvailabilityException {
		if (aStartingDate == null || anEndingDate == null ||
				!anEndingDate.isAfter(aStartingDate)) {
			throw new InvalidAvailabilityException();
		}
	}
}
