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
	public RentDto cancelRent(RentDto rentDto) throws IllegalRentAccessException, InvalidRentActionException;

	@POST
	@Path("/confirm-withdraw")
	public RentDto confirmWithdraw(RentDto rentDto) throws IllegalRentAccessException, InvalidRentActionException;

	@POST
	@Path("/confirm-return")
	public RentDto confirmReturn(RentDto rentDto) throws IllegalRentAccessException, InvalidRentActionException;

	@GET
	@Path("/search-rents")
	public List<RentDto> searchRents(RentFilterDto rentFilterDto); 

}
