package edu.unq.desapp.grupo_a.backend.model;

import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidRentException;

import java.time.LocalDate;

public class Rent extends PersistenceEntity {

	private User vehicleOwner;
	private Vehicle vehicle;
	private Address withdrawAddress;
	private Address returnAddress;
	private double rentPrice;
	private User renter;
	private LocalDate withdrawDate;
	private LocalDate returnDate;

	public Rent(Publication publication, int returnAddressIndex, User renter) {
		check(publication, returnAddressIndex, renter);
		this.vehicleOwner = publication.getOfferent();
		this.vehicle = publication.getVehicle();
		this.withdrawAddress = publication.getWithdrawAddress();
		this.returnAddress = publication.getReturnAddresses().get(returnAddressIndex);
		this.rentPrice = publication.getRentPrice();
		this.renter = renter;
		this.withdrawDate = publication.getAvailability().getStartingDate();
		this.returnDate = publication.getAvailability().getEndingDate();
	}

	private void check(Publication publication, int returnAddressIndex, User renter)
			throws InvalidRentException {
		if (publication == null ||
				publication.getOfferent() == renter) {
			throw new InvalidRentException();
		} else {
			Availability.check(publication);
			publication.getReturnAddresses().get(returnAddressIndex);
		}
	}

	public User getVehicleOwner() {
		return this.vehicleOwner;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public Address getWithdrawAddress() {
		return this.withdrawAddress;
	}
	
	public Address getReturnAddress() {
		return this.returnAddress;
	}

	public double getRentPrice() {
		return this.rentPrice;
	}

	public User getRenter() {
		return this.renter;
	}

	public LocalDate getWithdrawDate() {
		return this.withdrawDate;
	}

	public LocalDate getReturnDate() {
		return this.returnDate;
	}
}
