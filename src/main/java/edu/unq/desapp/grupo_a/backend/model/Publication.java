package edu.unq.desapp.grupo_a.backend.model;

import edu.unq.desapp.grupo_a.backend.model.exceptions.WrongPublicationException;

import java.util.List;

public class Publication {

	private User offerent;
	private Vehicle vehicle;
	private Address withdrawAddress;
	private List<Address> returnAddresses;
	private Boolean availability;
	private Double rentPrice;

	public Publication(User offerent, Vehicle vehicle) throws WrongPublicationException {
		try {
			check(offerent, vehicle);
		} catch (WrongPublicationException e) {
			throw e;
		}
		this.offerent = offerent;
		this.vehicle = vehicle;
	}

	private void check(User offerent, Vehicle vehicle) throws WrongPublicationException {
		if (offerent == null || vehicle == null ||
				!offerent.getVehicles().contains(vehicle)) {
			throw new WrongPublicationException();
		}
	}
}
