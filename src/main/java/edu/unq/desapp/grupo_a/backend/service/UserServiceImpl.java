package edu.unq.desapp.grupo_a.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unq.desapp.grupo_a.backend.service.UserService;
import edu.unq.desapp.grupo_a.backend.validators.UserValidator;
import edu.unq.desapp.grupo_a.backend.dao.UserRepository;
import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.model.exceptions.UserInitException;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserValidator userValidator;
	
	public UserServiceImpl() {
	}

	@Override
	public void createUser(User user) {
		
		try {
			
			userValidator.ValidateUser(user);
			
			userRepository.save(user);

		}catch(UserInitException e){
			
		}

		
	}

	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User update(User user) {
		
		return null;
		
	}

	@Override
	public void offerVehicle(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> searchUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
