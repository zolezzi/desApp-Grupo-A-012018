package edu.unq.desapp.grupo_a.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.desapp.grupo_a.backend.dao.UserRepository;
import edu.unq.desapp.grupo_a.backend.model.User;

@Transactional
@Service
public class UserServiceImpl extends GenericService<User> implements UserService{

	@Autowired
	private UserRepository UserRepository;

	public UserServiceImpl() {
	}

	public UserServiceImpl(UserRepository repo) {
		this.setRepository(repo);
	}

	public UserRepository getRepository() {
		return UserRepository;
	}

	public void setRepository(UserRepository repository) {
		this.UserRepository = repository;
	}

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
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

	//ToDo... implement
	//public void saveuser(UserDto dto) {
		
	//}
}
