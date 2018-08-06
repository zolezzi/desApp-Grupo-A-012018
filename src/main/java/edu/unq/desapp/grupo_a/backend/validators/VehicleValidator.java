package edu.unq.desapp.grupo_a.backend.validators;

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

    public void validateVehicle(Vehicle vehicle) throws VehicleDataException {
        VehicleType.check(vehicle.getVehicleType());
        validatePassengerCapability(vehicle.getPassengerCapability());
    }

    @Override
    public void validate(Object object) throws ExceptionInInitializerError {
        Vehicle vehicle = (Vehicle) object;
        validateVehicle(vehicle);
    }
}
