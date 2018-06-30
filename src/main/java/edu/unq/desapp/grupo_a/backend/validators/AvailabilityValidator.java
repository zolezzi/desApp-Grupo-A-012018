package edu.unq.desapp.grupo_a.backend.validators;

import edu.unq.desapp.grupo_a.backend.model.Availability;
import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidAvailabilityException;

public class AvailabilityValidator extends Validator {

    @Override
    public void validate(Object object) throws ExceptionInInitializerError {
        Availability availability = (Availability) object;
        validateAvailability(availability);
    }

    private void validateAvailability(Availability availability) throws InvalidAvailabilityException {
        if (    availability.getStartingDate() == null ||
                availability.getEndingDate() == null ||
                availability.getEndingDate().isBefore(availability.getStartingDate())) {
            throw new InvalidAvailabilityException();
        }
    }
}
