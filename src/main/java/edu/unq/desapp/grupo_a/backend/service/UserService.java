package edu.unq.desapp.grupo_a.backend.service;

import edu.unq.desapp.grupo_a.backend.dto.UserDto;
import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.model.Vehicle;

import java.util.List;

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

	public abstract void update(User user);
	
	public abstract List<User> searchUsers();
	
	public abstract User getUserForSocialNetwork(String facebookId, String googleId);
	
	public abstract User offerVehicle(Vehicle vehicle, Long id);

}
