package edu.unq.desapp.grupo_a.backend.model.builders;

import edu.unq.desapp.grupo_a.backend.model.Address;
import edu.unq.desapp.grupo_a.backend.model.User;

public class UserBuilder extends Builder {

	private String cuil = "no cuil";
	private String name = "no name";
	private Address address = new Address();
	private String email = "no email";

	public static UserBuilder anUser() {
		return new UserBuilder();
	}
	
	protected User fireBuild() {

		return new User(cuil, name, address, email);
	}

	public UserBuilder withCuil(final String aCuil) {
		cuil = aCuil;
		return this;
	}

	public UserBuilder withName(final String aName) {
		name = aName;
		return this;
	}

	public UserBuilder withAddress(final Address anAddress) {
		address = anAddress;
		return this;
	}

	public UserBuilder withEmail(final String anEmail) {
		email = anEmail;
		return this;
	}
}
