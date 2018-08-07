package edu.unq.desapp.grupo_a.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.unq.desapp.grupo_a.backend.model.Address;
import edu.unq.desapp.grupo_a.backend.model.Publication;
import edu.unq.desapp.grupo_a.backend.model.Rent;
import edu.unq.desapp.grupo_a.backend.model.RentFilter;
import edu.unq.desapp.grupo_a.backend.model.RentState;
import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.model.exceptions.IllegalRentAccessException;
import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidRentActionException;
import edu.unq.desapp.grupo_a.backend.repository.RentRepository;

@Service
public class RentServiceImpl implements RentService {

	private RentRepository rentRepository;

	@Override
	public Rent rentVehicle(Publication publication, Address address, User renter) {

		Rent rent = new Rent();
		rent.setReturnAddress(publication.getReturnAddress());
		rent.setRenter(renter);
		rent.setPublication(publication);
		rent.setVehicleOwner(publication.getOfferent());
		rent.setVehicle(publication.getVehicle());
		rent.setRentPrice(publication.getRentPrice());
		rent.setWithdrawAddress(publication.getWithdrawAddress());
		rent.setState(RentState.Pending);
		
		try {
			rent.pendingBy(renter);
		} catch (IllegalRentAccessException e) {
			e.printStackTrace();
		} catch (InvalidRentActionException e) {
			e.printStackTrace();
		}
		
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

	public RentRepository getRentRepository() {
		return rentRepository;
	}

	public void setRentRepository(RentRepository rentRepository) {
		this.rentRepository = rentRepository;
	}

	@Override
	public List<Rent> findAllRents(Long id) {
		
		return rentRepository.findAllRents(id);
	}

	@Override
	public List<Rent> findAllRentsByVehicleOwner(Long id) {

		return rentRepository.findAllRentsByVehicleOwner(id);
	}

	@Override
	public List<Rent> findAll() {
		 
		return rentRepository.findAll();
	}
}
