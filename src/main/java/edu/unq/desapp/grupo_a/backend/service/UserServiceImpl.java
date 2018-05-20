package edu.unq.desapp.grupo_a.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.desapp.grupo_a.backend.dao.UserRepository;
import edu.unq.desapp.grupo_a.backend.model.User;

@Transactional
@Service
public class UserServiceImpl extends GenericService<User> {

	@Autowired
	private UserRepository repository;

	public UserServiceImpl() {
	}

	public UserServiceImpl(UserRepository repo) {
		this.setRepository(repo);
	}

	public UserRepository getRepository() {
		return repository;
	}

	public void setRepository(UserRepository repository) {
		this.repository = repository;
	}

	//ToDo... implement
	//public void saveuser(UserDto dto) {
		
	//}
}
