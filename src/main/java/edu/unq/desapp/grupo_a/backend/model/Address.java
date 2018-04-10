package edu.unq.desapp.grupo_a.backend.model;

import edu.unq.desapp.grupo_a.backend.model.exceptions.UserInitException;

public class Address {

	public static void check(Address address) throws UserInitException {
		if (address == null) {
			throw new UserInitException();
		}
	}
}
