package edu.unq.desapp.grupo_a.backend.service;

import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.model.Vehicle;
import edu.unq.desapp.grupo_a.backend.model.VehicleFilter;
import edu.unq.desapp.grupo_a.backend.model.exceptions.UserInitException;
import edu.unq.desapp.grupo_a.backend.model.exceptions.VehicleDataException;
import edu.unq.desapp.grupo_a.backend.repository.UserRepository;
import edu.unq.desapp.grupo_a.backend.repository.VehicleRepository;
import edu.unq.desapp.grupo_a.backend.validators.UserValidator;
import edu.unq.desapp.grupo_a.backend.validators.VehicleValidator;

import java.util.List;

public class VehicleServiceImpl implements VehicleService{

    private VehicleValidator vehicleValidator;
    private UserValidator userValidator;
    private VehicleRepository vehicleRepository;
    private UserRepository userRepository;

	@Override
	public void addVehicle(Vehicle vehicle, User user) throws VehicleDataException, UserInitException {
		vehicleValidator.validateVehicle(vehicle);
	    userValidator.validateUser(user);
	    user.addVehicle(vehicle);
	    vehicleRepository.save(vehicle);
	    userRepository.update(user);
	}

	@Override
	public Vehicle getVehicle(Long id) {

		return vehicleRepository.findById(id);
	}

	@Override
	public void updateVehicle(Vehicle vehicle) throws VehicleDataException {
		vehicleValidator.validateVehicle(vehicle);
		vehicleRepository.update(vehicle);
	}

	@Override
	public void deleteVehicle(Long id) {

		Vehicle vehicle = vehicleRepository.findById(id);
		if (vehicle != null) {
			User user = vehicle.getUser();
			user.removeVehicle(vehicle);
			userRepository.update(user);
			vehicleRepository.delete(vehicle);
		}
	}

	@Override
	public List<Vehicle> searchVehicle(VehicleFilter vehicleFilter) {
		// TODO Auto-generated method stub
		return null;
	}

}
