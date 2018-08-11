package edu.unq.desapp.grupo_a.backend.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import edu.unq.desapp.grupo_a.backend.dto.PublicationDto;
import edu.unq.desapp.grupo_a.backend.dto.RentDto;
import edu.unq.desapp.grupo_a.backend.dto.RentFilterDto;
import edu.unq.desapp.grupo_a.backend.model.exceptions.IllegalRentAccessException;
import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidActionException;
import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidRentActionException;

@Path("/rents")
@Consumes({"application/xml", "application/json"})
@Produces({"application/xml", "application/json"})
public interface RentResource {
	
	@POST
	@Path("/rent-vehicle")
	public RentDto rentVehicle(RentDto rentDto);

	@GET
	@Path("/get-rent/{rentId}")
	public RentDto getRent(@PathParam("rentId") Long rentId);

	@POST
	@Path("/cancel-rent")
	public RentDto cancelRent(RentDto rentDto) throws InvalidActionException;

	@POST
	@Path("/confirm-withdraw/{id}/{userId}")
	public RentDto confirmWithdraw(@PathParam("id") Long id , @PathParam("userId") Long userId) throws InvalidActionException;

	@POST
	@Path("/confirm-return")
	public RentDto confirmReturn(RentDto rentDto) throws InvalidActionException;

	@GET
	@Path("/search-rents")
	public List<RentDto> searchRents(RentFilterDto rentFilterDto); 
	
	@GET
	@Path("all-rents/{id}")
	public List<RentDto> findAllRents(@PathParam("id") Long id);
	
	@GET
	@Path("all-rents-owner-vehicle/{id}")
	public List<RentDto> findAllRentsByVehicleOwner(@PathParam("id") Long id);
	

}
