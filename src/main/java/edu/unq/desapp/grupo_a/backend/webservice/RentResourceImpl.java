package edu.unq.desapp.grupo_a.backend.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import edu.unq.desapp.grupo_a.backend.model.Publication;
import edu.unq.desapp.grupo_a.backend.model.Rent;
import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.model.builders.RentBuilder;
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

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public RentDto rentVehicle(PublicationDto publicationDto, int returnIndex, Long renterId) {

		Publication publication = modelMapper.map(publicationDto, Publication.class);
		User renter = userService.getUser(renterId);

		Rent rent = rentService.rentVehicle(publication, returnIndex, renter);

		return modelMapper.map(rent, RentDto.class);
	}

	@Override
	public RentDto getRent(Long rentId) {

		Rent rent = rentService.getRent(rentId);

		return modelMapper.map(rent, RentDto.class);
	}

	@Override
	public RentDto cancelRent(Long rentId, Long userId) {

		Rent rent = rentService.getRent(rentId);
		User user = userService.getUser(userId);

		rent = rentService.cancelRent(rent, user);

		return modelMapper.map(rent, RentDto.class);
	}

	@Override
	public RentDto confirmWithdraw(Long rentId, Long userId) {

		Rent rent = rentService.getRent(rentId);
		User user = userService.getUser(userId);

		rent = rentService.confirmWithdraw(rent, user);

		return modelMapper.map(rent, RentDto.class);
	}

	@Override
	public RentDto confirmReturn(Long rentId, Long userId) {

		Rent rent = rentService.getRent(rentId);
		User user = userService.getUser(userId);

		rent = rentService.confirmReturn(rent, user);

		return modelMapper.map(rent, RentDto.class);
	}

	@Override
	public List<RentDto> searchRents(RentFilterDto rentFilterDto) {
		// TODO Auto-generated method stub
		return null;
	}
 
}
