package edu.unq.desapp.grupo_a.backend.service;

import java.util.List;

import edu.unq.desapp.grupo_a.backend.model.Publication;
import edu.unq.desapp.grupo_a.backend.model.Rent;
import edu.unq.desapp.grupo_a.backend.model.RentFilter;
import edu.unq.desapp.grupo_a.backend.model.User;

public interface RentService {
	
	public Rent rentVehicle(Publication publication, int returnIndex, User renter);
	
	public List<Rent> searchRents(RentFilter rentFilter, User user);

	public Rent getRent(Long rentId);

	public Rent cancelRent(Rent rent, User user);

	public Rent confirmWithdraw(Rent rent, User user);

	public Rent confirmReturn(Rent rent, User user);
}
