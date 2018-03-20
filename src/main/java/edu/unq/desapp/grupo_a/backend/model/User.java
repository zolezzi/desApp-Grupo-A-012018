package edu.unq.desapp.grupo_a.backend.model;

import java.util.List;

public class User {

	private String cuil;
	
	private String name;
	
	private Address address;

	private String email;
	
	private Integer reputation;
	
	private List<Vehicle> vehicles;
	
	private CreditAccount creditAccount;
	
	public User(String cuil, String name, Address address, String email) {
		
		this.cuil = cuil;
		this.name = name;
		this.address = address;
		this.email = email;
		this.reputation = 0;
	}
	
	public User() {
		
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

	public Integer getReputation() {
		return reputation;
	}

	public void setReputation(Integer reputation) {
		this.reputation = reputation;
	}

}
