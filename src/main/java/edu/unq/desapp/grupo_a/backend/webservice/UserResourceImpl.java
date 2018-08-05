package edu.unq.desapp.grupo_a.backend.webservice;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.desapp.grupo_a.backend.api.UserResource;
import edu.unq.desapp.grupo_a.backend.dto.UserDto;
import edu.unq.desapp.grupo_a.backend.dto.VehicleDto;
import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.model.Vehicle;
import edu.unq.desapp.grupo_a.backend.service.UserService;

@Service
@Produces("application/json")
@Consumes("application/json")
@Path("/users")
public class UserResourceImpl implements UserResource{

	private UserService userService;
	
	ModelMapper modelMapper = new ModelMapper(); 

	@Override
	@Transactional(readOnly = false)
	public UserDto createUser(UserDto userDto) {

			
		User user =	modelMapper.map(userDto, User.class);
		
		user = userService.createUser(user);		
	
		return user.toDto();

	}

	@Override
	public UserDto update(UserDto userDto) {
			
		User user =	modelMapper.map(userDto, User.class);
		
		userService.update(user);
		
		return modelMapper.map(user, UserDto.class);
	
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

	@Override
	@Transactional
	public UserDto getUserForSocialNetwork(UserDto userDto) {
		
		User user = userService.getUserForSocialNetwork(userDto.idFacebook, userDto.idGoogle);
		
		UserDto userDtoDefault;
		
		if(user == null) {
			userDtoDefault = new UserDto();
			userDtoDefault.setIdGoogle(userDto.getIdGoogle());
			userDtoDefault.setIdFacebook(userDto.getIdFacebook());
			userDtoDefault.setIsRegister(false);
		}else {
			userDtoDefault = user.toDto();
			userDtoDefault.setIsRegister(true);
		}
		
		return userDtoDefault;
	}

	@Override
	public UserDto offerVehicle(VehicleDto vehicleDto, Long id) {
		
		Vehicle vehicle = modelMapper.map(vehicleDto, Vehicle.class);
		
		User user = userService.offerVehicle(vehicle, id); 
		
		return modelMapper.map(user , UserDto.class);
	}


}
