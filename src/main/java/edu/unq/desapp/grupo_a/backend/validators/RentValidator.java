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
//        validateRentParts(rent.getVehicleOwner(), rent.getRenter());
//        validateRentVehicle(rent.getVehicleOwner(), rent.getVehicle());
        validateWithdrawDate(rent.getWithdrawDate());
    }

    private void validateWithdrawDate(Date withdrawDate) throws InvalidAvailabilityException {
        if (withdrawDate.before(java.sql.Date.valueOf(LocalDate.now()))){
            throw new InvalidAvailabilityException();
        }
    }

    private void validateRentParts(User vehicleOwner, User renter) throws InvalidRentException {
        if (    vehicleOwner == null ||
                renter == null ||
                vehicleOwner == renter) {
            throw new InvalidRentException();
        }
    }

    private void validateRentVehicle(User vehicleOwner, Vehicle vehicle) throws InvalidRentException {
        if (    vehicleOwner == null ||
                vehicle == null ||
                !vehicleOwner.getVehicles().contains(vehicle)) {
            throw new InvalidRentException();
        }
    }
}
