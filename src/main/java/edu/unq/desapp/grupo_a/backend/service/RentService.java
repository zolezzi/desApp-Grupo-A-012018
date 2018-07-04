package edu.unq.desapp.grupo_a.backend.service;

import java.util.List;

import edu.unq.desapp.grupo_a.backend.model.Address;
import edu.unq.desapp.grupo_a.backend.model.Publication;
import edu.unq.desapp.grupo_a.backend.model.Rent;
import edu.unq.desapp.grupo_a.backend.model.RentFilter;
import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.model.exceptions.IllegalRentAccessException;
import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidRentActionException;

public interface RentService {
	
	public Rent rentVehicle(Publication publication, Address returnIndex, User renter);
	
	public List<Rent> searchRents(RentFilter rentFilter, User user);

	public Rent getRent(Long rentId);

	public Rent cancelRent(Rent rent, User user) throws IllegalRentAccessException, InvalidRentActionException;

	public Rent confirmWithdraw(Rent rent, User user) throws IllegalRentAccessException, InvalidRentActionException;

	public Rent confirmReturn(Rent rent, User user) throws IllegalRentAccessException, InvalidRentActionException;
}
