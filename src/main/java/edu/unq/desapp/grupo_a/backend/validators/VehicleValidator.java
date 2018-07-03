package edu.unq.desapp.grupo_a.backend.validators;

import edu.unq.desapp.grupo_a.backend.model.Photo;
import edu.unq.desapp.grupo_a.backend.model.Vehicle;
import edu.unq.desapp.grupo_a.backend.model.VehicleType;
import edu.unq.desapp.grupo_a.backend.model.exceptions.VehicleDataException;

public class VehicleValidator extends Validator{

    public VehicleValidator() {

    }

    private void validatePassengerCapability(int passengerCapability) throws VehicleDataException {
        if (passengerCapability <= 0) {
            throw new VehicleDataException();
        }
    }

    private void validateVehiclePatent(String vehiclePatent) throws VehicleDataException {
        if (vehiclePatent == null || vehiclePatent.trim().isEmpty()) {
            throw new VehicleDataException();
        }
    }

    public void validateVehicle(Vehicle vehicle) throws VehicleDataException {
        VehicleType.check(vehicle.getVehicleType());
        //Photo.check(vehicle.getPhotos());
        validatePassengerCapability(vehicle.getPassengerCapability());
        validateVehiclePatent(vehicle.getPatent());
    }

    @Override
    public void validate(Object object) throws ExceptionInInitializerError {
        Vehicle vehicle = (Vehicle) object;
        validateVehicle(vehicle);
    }
}
