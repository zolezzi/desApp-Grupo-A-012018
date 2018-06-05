package edu.unq.desapp.grupo_a.backend.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unq.desapp.grupo_a.backend.api.UserResource;
import edu.unq.desapp.grupo_a.backend.dao.UserRepository;
import edu.unq.desapp.grupo_a.backend.dto.UserDto;
import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.service.UserServiceImpl;

@Service
@Produces("application/json")
@Consumes("application/json")
@Path("/users")
public class UserResourceImpl implements UserResource{
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	ModelMapper modelMapper; 

	@Override
	public UserDto createUser(UserDto userDto) {

			
		User user =	modelMapper.map(userDto, User.class);
		
		userService.createUser(user);		
	
		return userDto;

	}

	@Override
	public UserDto update(UserDto userDto) {
			
		User user =	modelMapper.map(userDto, User.class);
		
		User userUpdate = userService.update(user);
		
		return modelMapper.map(userUpdate, UserDto.class);
	
	}

	@Override
	public UserDto offerVehicle(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> searchUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto deleteUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public UserServiceImpl getUserService() {
		return userService;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

}
