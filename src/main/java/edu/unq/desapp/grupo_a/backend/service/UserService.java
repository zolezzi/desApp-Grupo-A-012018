package edu.unq.desapp.grupo_a.backend.service;

import java.util.List;

import edu.unq.desapp.grupo_a.backend.model.User;

/**
 * 
 * Servicios para los usuarios.
 * 
 * @author Charlie Cardozo
 *
 */
public interface UserService {
	
	public abstract void createUser(User user);
	
	public abstract User getUser(Long id);
	
	public abstract void deleteUser(Long id);

	public abstract User update(User user);
	
	public abstract void offerVehicle (User user);
	
	public abstract List<User> searchUsers();


}
