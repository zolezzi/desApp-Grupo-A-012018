package edu.unq.desapp.grupo_a.backend.service;

import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.model.Vehicle;
import edu.unq.desapp.grupo_a.backend.model.VehicleFilter;
import edu.unq.desapp.grupo_a.backend.model.VehicleType;

import java.util.List;

public interface VehicleService {
	
	public abstract void addVehicle(Vehicle vehicle, User user );
	
	public abstract Vehicle getVehicle(Long id);
	
	public abstract void updateVehicle(Vehicle vehicle);
	
	public abstract void deleteVehicle(Long id);

	public abstract List<Vehicle> searchVehicle(VehicleFilter vehicleFilter);
	
	public abstract List<VehicleType> searchAllVehicleType();
	
	public abstract List<Vehicle> allMyVehiclesRegitered(Long id);

}
