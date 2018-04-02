package edu.unq.desapp.grupo_a.backend.model;

import java.util.List;

import edu.unq.desapp.grupo_a.backend.model.exceptions.VehicleDataException;

public class Vehicle {
	
	private VehicleData vehicleData;
	
	private Address withdrawAddress;
	
	private List<Address> returnAddresses;

	private Boolean availability;
	
	private Double rentPrice;
	
	private List<Photo> photos;
	
	public Vehicle (VehicleData vehicleData, Address withdrawAddress,
			List<Address> returnAddresses, Boolean availability, Double rentPrice,
			List<Photo> photos) throws VehicleDataException {
		try {
			VehicleData.check(vehicleData);
		} catch(VehicleDataException e) {
			throw e;
		}
		this.vehicleData = vehicleData;
		this.setWithdrawAddress(withdrawAddress);
		this.setReturnAddresses(returnAddresses);
		this.setAvailability(availability);
		this.setRentPrice(rentPrice);
		this.setPhotos(photos);
	}
	
	public VehicleData getVehicleData() {
		return this.vehicleData;
	}

	public Address getWithdrawAddress() {
		return withdrawAddress;
	}

	public void setWithdrawAddress(Address withdrawAddress) {
		this.withdrawAddress = withdrawAddress;
	}

	public List<Address> getReturnAddresses() {
		return returnAddresses;
	}

	public void setReturnAddresses(List<Address> returnAddresses) {
		this.returnAddresses = returnAddresses;
	}

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

	public Double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
}
