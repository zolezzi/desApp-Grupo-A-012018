package edu.unq.desapp.grupo_a.backend.model;

import edu.unq.desapp.grupo_a.backend.model.builders.AvailabilityBuilder;
import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidAvailabilityException;
import org.junit.Test;

import java.time.LocalDate;

public class AvailabilityTest {

    @Test (expected = InvalidAvailabilityException.class)
    public void testInvalidAvailability() {
        LocalDate aStartDate = LocalDate.now();
        LocalDate anEndingDate = LocalDate.now().minusDays(1);

        AvailabilityBuilder.anAvailability()
                .withStartDate(aStartDate)
                .withEndingDate(anEndingDate)
                .build();
    }
}
