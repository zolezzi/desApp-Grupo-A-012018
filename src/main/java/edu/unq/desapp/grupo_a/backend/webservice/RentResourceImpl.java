package edu.unq.desapp.grupo_a.backend.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import edu.unq.desapp.grupo_a.backend.model.Address;
import edu.unq.desapp.grupo_a.backend.model.Publication;
import edu.unq.desapp.grupo_a.backend.model.Rent;
import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.model.builders.RentBuilder;
import edu.unq.desapp.grupo_a.backend.model.exceptions.IllegalRentAccessException;
import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidRentActionException;
import edu.unq.desapp.grupo_a.backend.service.PublicationService;
import edu.unq.desapp.grupo_a.backend.service.RentService;
import edu.unq.desapp.grupo_a.backend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import edu.unq.desapp.grupo_a.backend.api.RentResource;
import edu.unq.desapp.grupo_a.backend.dto.PublicationDto;
import edu.unq.desapp.grupo_a.backend.dto.RentDto;
import edu.unq.desapp.grupo_a.backend.dto.RentFilterDto;

@Service
@Produces("application/json")
@Consumes("application/json")
@Path("/rents")
public class RentResourceImpl implements RentResource{

	private RentService rentService;
	private UserService userService;
	private PublicationService publicationService;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public RentDto rentVehicle(RentDto rentDto) {
		
		Publication publication = publicationService.getPublication(rentDto.getPublicationId());

		User renter = userService.getUser(rentDto.getRenterId());
		
		Address address = modelMapper.map(rentDto.getAddressDto(), Address.class);

		Rent rent = rentService.rentVehicle(publication, address, renter);

		return modelMapper.map(rent, RentDto.class);
	}

	@Override
	public RentDto getRent(Long rentId) {

		Rent rent = rentService.getRent(rentId);

		return modelMapper.map(rent, RentDto.class);
	}

	@Override
	public RentDto cancelRent(RentDto rentDto) throws IllegalRentAccessException, InvalidRentActionException {

		Rent rent = rentService.getRent(rentDto.getRenterId());
		User user = userService.getUser(rentDto.getUserId());

		rent = rentService.cancelRent(rent, user);

		return modelMapper.map(rent, RentDto.class);
	}

	@Override
	public RentDto confirmWithdraw(RentDto rentDto) throws IllegalRentAccessException, InvalidRentActionException {

		Rent rent = rentService.getRent(rentDto.getRenterId());
		User user = userService.getUser(rentDto.getUserId());

		rent = rentService.confirmWithdraw(rent, user);

		return modelMapper.map(rent, RentDto.class);
	}

	@Override
	public RentDto confirmReturn(RentDto rentDto) throws IllegalRentAccessException, InvalidRentActionException {

		Rent rent = rentService.getRent(rentDto.getRenterId());
		User user = userService.getUser(rentDto.getUserId());

		rent = rentService.confirmReturn(rent, user);

		return modelMapper.map(rent, RentDto.class);
	}

	@Override
	public List<RentDto> searchRents(RentFilterDto rentFilterDto) {
		// TODO Auto-generated method stub
		return null;
	}
 
}
