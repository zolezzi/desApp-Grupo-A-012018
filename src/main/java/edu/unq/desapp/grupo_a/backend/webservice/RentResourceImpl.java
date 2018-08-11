package edu.unq.desapp.grupo_a.backend.webservice;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidActionException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.desapp.grupo_a.backend.api.RentResource;
import edu.unq.desapp.grupo_a.backend.dto.RentDto;
import edu.unq.desapp.grupo_a.backend.dto.RentFilterDto;
import edu.unq.desapp.grupo_a.backend.model.Address;
import edu.unq.desapp.grupo_a.backend.model.Publication;
import edu.unq.desapp.grupo_a.backend.model.Rent;
import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.model.exceptions.IllegalRentAccessException;
import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidRentActionException;
import edu.unq.desapp.grupo_a.backend.service.PublicationService;
import edu.unq.desapp.grupo_a.backend.service.RentService;
import edu.unq.desapp.grupo_a.backend.service.UserService;

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
	@Transactional(readOnly = false)
	public RentDto rentVehicle(RentDto rentDto) {
		
		Publication publication = publicationService.getPublication(rentDto.getPublicationId());

		User renter = userService.getUser(rentDto.getRenterId());
		
		//Address address = modelMapper.map(rentDto.getAddressDto(), Address.class);

		Rent rent = rentService.rentVehicle(publication, publication.getReturnAddress(), renter);

		return modelMapper.map(rent, RentDto.class);
	}

	@Override
	public RentDto getRent(Long rentId) {

		Rent rent = rentService.getRent(rentId);

		return modelMapper.map(rent, RentDto.class);
	}

	@Override
	@Transactional
	public RentDto cancelRent(RentDto rentDto) throws InvalidActionException {

		Rent rent = rentService.getRent(rentDto.getRenterId());
		User user = userService.getUser(rentDto.getUserId());

		rent = rentService.cancelRent(rent, user);

		return modelMapper.map(rent, RentDto.class);
	}

	@Override
	@Transactional(readOnly = false)
	public RentDto confirmWithdraw(Long id, Long userId) throws InvalidActionException {

//		Rent rent = rentService.getRent(rentDto.getId());
//		User user = userService.getUser(rentDto.getUserId());
		Rent rent = rentService.getRent(id);
		User user = userService.getUser(userId);
		
//		List<Rent> list = rentService.findAll().stream().filter(r -> !r.getId().equals(id) ).collect(Collectors.toList());
//		
//		Rent rent = list.get(0); 
		
		rent = rentService.confirmWithdraw(rent, user);

		return modelMapper.map(rent, RentDto.class);
	}

	@Override
	@Transactional(readOnly = false)
	public RentDto confirmReturn(RentDto rentDto) throws InvalidActionException {

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

	public RentService getRentService() {
		return rentService;
	}

	public void setRentService(RentService rentService) {
		this.rentService = rentService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public PublicationService getPublicationService() {
		return publicationService;
	}

	public void setPublicationService(PublicationService publicationService) {
		this.publicationService = publicationService;
	}

	@Override
	@Transactional
	public List<RentDto> findAllRents(Long id) {
		
		List<Rent> rents = rentService.findAllRents(id);
	
		return rents.stream().map(rent -> rent.toDto()).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public List<RentDto> findAllRentsByVehicleOwner(Long id) {
		
		List<Rent> rents = rentService.findAllRentsByVehicleOwner(id);
		
		return rents.stream().map(rent -> rent.toDto()).collect(Collectors.toList());
	}
 
}
