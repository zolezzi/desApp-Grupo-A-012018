package edu.unq.desapp.grupo_a.backend.model;

import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidRentException;

public class Rent {

	private User vehicleOwner;
	private Vehicle vehicle;
	private Address withdrawAddress;
	private Address returnAddress;
	private double rentPrice;
	
	public Rent(Publication publication, int returnAddressIndex) {
		try {
			check(publication, returnAddressIndex);
		} catch (InvalidRentException e) {
			throw e;
		}
		this.vehicleOwner = publication.getOfferent();
		this.vehicle = publication.getVehicle();
		this.withdrawAddress = publication.getWithdrawAddress();
		this.returnAddress = publication.getReturnAddresses().get(returnAddressIndex);
		this.rentPrice = publication.getRentPrice();
	}

	private void check(Publication publication, int returnAddressIndex)
			throws InvalidRentException {
		if (publication == null) {
			throw new InvalidRentException();
		} else {
			try {
				publication.getReturnAddresses().get(returnAddressIndex);
			} catch (IndexOutOfBoundsException e) {
				throw new InvalidRentException();
			}
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
}
