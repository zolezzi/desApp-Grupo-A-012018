package edu.unq.desapp.grupo_a.backend.webservice;

import edu.unq.desapp.grupo_a.backend.api.VehicleResource;
import edu.unq.desapp.grupo_a.backend.dto.VehicleDto;
import edu.unq.desapp.grupo_a.backend.dto.VehicleFilterDto;
import edu.unq.desapp.grupo_a.backend.dto.VehicleTypeDto;
import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.model.Vehicle;
import edu.unq.desapp.grupo_a.backend.model.VehicleFilter;
import edu.unq.desapp.grupo_a.backend.model.VehicleType;
import edu.unq.desapp.grupo_a.backend.service.UserService;
import edu.unq.desapp.grupo_a.backend.service.VehicleService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Produces("application/json")
@Consumes("application/json")
@Path("/vehicles")
public class VehicleResourceImpl implements VehicleResource{

	private VehicleService vehicleService;
	private UserService userService;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly = false)
	public Response addVehicle(VehicleDto vehicleDto) {

		Vehicle vehicle = modelMapper.map(vehicleDto, Vehicle.class);
		
		VehicleType vehicleType = VehicleType.valueOf(vehicleDto.getVehicleType());
		
		if( vehicleType != null ) {
			vehicle.setVehicleType(vehicleType);
		}
		User user = userService.getUser(vehicleDto.getUserId());
		
		vehicleService.addVehicle(vehicle, user);

		return null;
	}

	@Override
	public VehicleDto getVehicle(Long id) {

		Vehicle vehicle = vehicleService.getVehicle(id);

		return modelMapper.map(vehicle, VehicleDto.class);
	}

	@Override
	public VehicleDto updateVehicle(VehicleDto vehicleDto) {

		Vehicle vehicle = modelMapper.map(vehicleDto, Vehicle.class);

		vehicleService.updateVehicle(vehicle);

		return modelMapper.map(vehicle, VehicleDto.class);
	}

	@Override
	public Response deleteVehicle(Long id) {

		vehicleService.deleteVehicle(id);

		return null;
	}

	@Override
	public List<VehicleDto> searchVehicle(VehicleFilterDto vehicleFilterDto) {
		
		VehicleFilter vehicleFilter = modelMapper.map(vehicleFilterDto, VehicleFilter.class);
		
		List<Vehicle> vehicles =  vehicleService.searchVehicle(vehicleFilter);
		
		return vehicles.stream().map(vehicle -> vehicle.toDto()).collect(Collectors.toList());
	}

	public VehicleService getVehicleService() {
		return vehicleService;
	}

	public void setVehicleService(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ModelMapper getModelMapper() {
		return modelMapper;
	}

	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public List<VehicleTypeDto> searchAllTypeVehicle() {
		
		List<VehicleType> vehicleList = vehicleService.searchAllVehicleType();
		
		return vehicleList.stream().map(vehicleType -> vehicleType.toDto()).collect(Collectors.toList());
	
	}

	@Override
	@Transactional(readOnly = false)
	public List<VehicleDto> allMyVehiclesRegitered(Long id) {
		
		List<Vehicle> vehiclesRegitered = vehicleService.allMyVehiclesRegitered(id);
		

		
		return vehiclesRegitered.stream().map(vehicle -> vehicle.toDto()).collect(Collectors.toList());
	}
}
