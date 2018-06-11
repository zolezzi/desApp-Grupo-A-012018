package edu.unq.desapp.grupo_a.backend.webservice;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import edu.unq.desapp.grupo_a.backend.api.UserResource;
import edu.unq.desapp.grupo_a.backend.dto.UserDto;
import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.service.UserService;

@Service
@Produces("application/json")
@Consumes("application/json")
@Path("/users")
public class UserResourceImpl implements UserResource{

	private UserService userService;
	
	ModelMapper modelMapper = new ModelMapper(); 

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
	public List<UserDto> searchUsers() {
		
		return userService.searchUsers().stream().map(user -> user.toDto()).collect(Collectors.toList());
		
	}

	@Override
	public UserDto getUser(Long id) {	
		
		User user = userService.getUser(id); 
		
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto deleteUser(Long id) {
		
		userService.deleteUser(id);

		return null;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public ModelMapper getModelMapper() {
		return modelMapper;
	}

	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}


}
