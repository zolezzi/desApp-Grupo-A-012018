package edu.unq.desapp.grupo_a.backend.model;

import java.util.ArrayList;
import java.util.Collection;

import edu.unq.desapp.grupo_a.backend.model.exceptions.UserInitException;

public class User {

	private String cuil;
	private String name;
	private Address address;
	private String email;
	private Double reputation;
	private Collection<Vehicle> vehicles;
	private CreditAccount creditAccount;
	
	public User(String cuil, String name, Address address, String email) throws UserInitException{
		try {
			check(cuil, name, address, email);
		} catch (UserInitException e) {
			throw e;
		}
		this.cuil = cuil;
		this.name = name;
		this.address = address;
		this.email = email;
		this.reputation = (double) 0;
		this.vehicles = new ArrayList<>();
		this.creditAccount = new CreditAccount();
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getReputation() {
		return reputation;
	}

	public void setReputation(Double reputation) {
		this.reputation = reputation;
	}
	
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}

	public void addVehicle(Vehicle vehicle) {
		this.vehicles.add(vehicle);
	}
	
	public void removeVehicle(Vehicle vehicle) {
		this.vehicles.remove(vehicle);
	}

	public CreditAccount getCreditAccount() {
		return creditAccount;
	}

	public void addCredit(Double amount) {
		this.creditAccount.addAmount(amount);
	}
	
	public void loseCredit(Double amount) {
		this.creditAccount.loseAmount(amount);
	}
	
	private static void check(String cuil, String name, Address address,
			String email) throws UserInitException {
		if (name == null || name.trim().isEmpty() ||
				cuil == null || cuil.trim().isEmpty() ||
				email == null || email.trim().isEmpty()) {
			throw new UserInitException();
		} else {
			Address.check(address);
		}
	}
}
