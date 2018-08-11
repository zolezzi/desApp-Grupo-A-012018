package edu.unq.desapp.grupo_a.backend.validators;

import edu.unq.desapp.grupo_a.backend.model.Rent;
import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.model.Vehicle;
import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidAvailabilityException;
import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidRentException;

import java.time.LocalDate;
import java.util.Date;

public class RentValidator extends Validator {

    @Override
    public void validate(Object object) throws ExceptionInInitializerError {
        Rent rent = (Rent) object;
        validateWithdrawDate(rent.getWithdrawDate());
    }

    private void validateWithdrawDate(Date withdrawDate) throws InvalidAvailabilityException {
        if (withdrawDate.before(java.sql.Date.valueOf(LocalDate.now()))){
            throw new InvalidAvailabilityException("La fecha de retiro del vehículo no puede ser anterior al día de hoy");
        }
    }
}
