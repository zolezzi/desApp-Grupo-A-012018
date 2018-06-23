package edu.unq.desapp.grupo_a.backend.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.model.exceptions.UserInitException;
import edu.unq.desapp.grupo_a.backend.repository.UserRepository;
import edu.unq.desapp.grupo_a.backend.validators.UserValidator;


@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	private UserValidator userValidator;
	
	public UserServiceImpl() {
	}

	@Override
	public void createUser(User user) throws UserInitException {
		userValidator.validateUser(user);
		userRepository.save(user);
	}

	@Override
	public User getUser(Long id) {

		return userRepository.findById(id);
	}

	@Override
	public void deleteUser(Long id) {
		
		User user = userRepository.findById(id);
		
		if(user != null) {
			userRepository.delete(user);
		}
	}

	@Override
	public void update(User user) throws UserInitException {
		userValidator.validateUser(user);
		userRepository.update(user);
	}

	@Override
	public List<User> searchUsers() {
		
		User user1 = new User();
		user1.setId(1L);
		user1.setName("c1");
		user1.setEmail("saraza");
		user1.setReputation(4);
		
		
		User user2 = new User();
		user2.setId(2L);
		user2.setName("c2");
		user2.setEmail("saraza2");
		user2.setReputation(4);
		
		
		return Arrays.asList(user1, user2);
		
		//return userRepository.findAll();
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserValidator getUserValidator() {
		return userValidator;
	}

	public void setUserValidator(UserValidator userValidator) {
		this.userValidator = userValidator;
	}

}
