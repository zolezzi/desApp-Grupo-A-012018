package edu.unq.desapp.grupo_a.backend.service;

import java.util.List;

import edu.unq.desapp.grupo_a.backend.model.Address;
import edu.unq.desapp.grupo_a.backend.model.Publication;
import edu.unq.desapp.grupo_a.backend.model.Rent;
import edu.unq.desapp.grupo_a.backend.model.RentFilter;
import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.model.builders.RentBuilder;
import edu.unq.desapp.grupo_a.backend.model.exceptions.IllegalRentAccessException;
import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidRentActionException;
import edu.unq.desapp.grupo_a.backend.repository.RentRepository;

public class RentServiceImpl implements RentService {

	private RentRepository rentRepository;

	@Override
	public Rent rentVehicle(Publication publication, Address address, User renter) {

		Rent rent = (Rent) RentBuilder.aRent()
							.fromPublication(publication)
							.withReturnAddress(address)
							.withRenter(renter)
							.build();

		rentRepository.save(rent);

		return rent;
	}

	@Override
	public Rent getRent(Long rentId) {

		return rentRepository.findById(rentId);
	}

	@Override
	public Rent cancelRent(Rent rent, User user) throws IllegalRentAccessException, InvalidRentActionException {

		rent.cancelBy(user);
		rentRepository.update(rent);
		return rent;
	}

	@Override
	public Rent confirmWithdraw(Rent rent, User user) throws IllegalRentAccessException, InvalidRentActionException {

		rent.confirmWithdrawBy(user);
		rentRepository.update(rent);
		return rent;
	}

	@Override
	public Rent confirmReturn(Rent rent, User user) throws IllegalRentAccessException, InvalidRentActionException {

		rent.confirmReturnBy(user);
		rentRepository.update(rent);
		return rent;
	}

	@Override
	public List<Rent> searchRents(RentFilter rentFilter, User user) {
		// TODO Auto-generated method stub
		return null;
	}
}
