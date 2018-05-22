package edu.unq.desapp.grupo_a.backend.model;

import edu.unq.desapp.grupo_a.backend.model.exceptions.WrongAddressException;
import edu.unq.desapp.grupo_a.backend.model.exceptions.WrongPublicationException;

import java.util.List;

public class Publication {

	private User offerent;
	private Vehicle vehicle;
	private Address withdrawAddress;
	private List<Address> returnAddresses;
	private Availability availability;
	private Double rentPrice;

    public Publication(User offerent, Vehicle vehicle, Address withdrawAddress,
                       List<Address> returnAddresses, Availability availability, double rentPrice)
            throws WrongPublicationException, WrongAddressException {
        try {
            check(offerent, vehicle, rentPrice);
            Address.check(withdrawAddress);
            Address.check(returnAddresses);
            Availability.check(availability);
        } catch (WrongPublicationException | WrongAddressException e) {
            throw e;
        }
        this.offerent = offerent;
        this.vehicle = vehicle;
        this.withdrawAddress = withdrawAddress;
        this.returnAddresses = returnAddresses;
        this.availability = availability;
        this.rentPrice = rentPrice;
    }

    private void check(User offerent, Vehicle vehicle, double rentPrice) throws WrongPublicationException {
        if (offerent == null || vehicle == null ||
                !offerent.getVehicles().contains(vehicle) ||
                rentPrice <= 0) {
            throw new WrongPublicationException();
        }
    }

    public User getOfferent() {
        return offerent;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Address getWithdrawAddress() {
        return withdrawAddress;
    }

    public List<Address> getReturnAddresses() {
        return returnAddresses;
    }

    public Availability getAvailability() {
        return availability;
    }

    public Double getRentPrice() {
        return rentPrice;
    }
}
