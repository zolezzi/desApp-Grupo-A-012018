package edu.unq.desapp.grupo_a.backend.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import edu.unq.desapp.grupo_a.backend.dto.PublicationDto;
import edu.unq.desapp.grupo_a.backend.dto.RentDto;
import edu.unq.desapp.grupo_a.backend.dto.RentFilterDto;

public interface RentResource {
	
	@POST
	@Path("/rent-vehicle/{returnIndex}{renterId}")
	public RentDto rentVehicle(PublicationDto publicationDto, @PathParam("returnIndex") int returnIndex,
							   @PathParam("renterId") Long id);

	@GET
	@Path("/get-rent/{rentId}")
	public RentDto getRent(@PathParam("rentId") Long rentId);

	@POST
	@Path("/cancel-rent/{rentId}{userId}")
	public RentDto cancelRent(@PathParam("rentId") Long rentId, @PathParam("userId") Long userId);

	@POST
	@Path("/confirm-withdraw/{rentId}{userId}")
	public RentDto confirmWithdraw(@PathParam("rentId") Long rentId, @PathParam("userId") Long userId);

	@POST
	@Path("/confirm-return/{rentId}{userId}")
	public RentDto confirmReturn(@PathParam("rentId") Long rentId, @PathParam("userId") Long userId);

	@GET
	@Path("/search-rents")
	public List<RentDto> searchRents(RentFilterDto rentFilterDto); 

}
