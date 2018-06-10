package edu.unq.desapp.grupo_a.backend.model.builders;

import edu.unq.desapp.grupo_a.backend.model.Availability;

import java.time.LocalDate;

public class AvailabilityBuilder {

	private LocalDate aStartingDate = LocalDate.now();
	private LocalDate anEndingDate = LocalDate.now().plusDays(2);

	public static AvailabilityBuilder anAvailability() {
		return new AvailabilityBuilder();
	}

	public Availability build() {
		return new Availability(aStartingDate, anEndingDate);
	}

	public AvailabilityBuilder withStartDate(LocalDate anStartDate) {
		aStartingDate = anStartDate;
		return this;
	}

	public AvailabilityBuilder withEndingDate(LocalDate anEndDate) {
		anEndingDate = anEndDate;
		return this;
	}
}
