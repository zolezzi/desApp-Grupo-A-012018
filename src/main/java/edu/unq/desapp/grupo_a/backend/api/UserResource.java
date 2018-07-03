package edu.unq.desapp.grupo_a.backend.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.unq.desapp.grupo_a.backend.dto.UserDto;
import edu.unq.desapp.grupo_a.backend.dto.VehicleDto;


@Path("/users")
@Consumes({"application/xml", "application/json"})
@Produces({"application/xml", "application/json"})
public interface UserResource {
	
	@POST
	@Produces({MediaType.APPLICATION_JSON}) 
	@Path("/add-user")
	public UserDto createUser(UserDto userDto);
	
	@GET
	@Produces({MediaType.APPLICATION_JSON}) 
	@Path("/get-user/{id}")
	public UserDto getUser(@PathParam("id")  Long id);
	
	@DELETE
	@Path("/delete-user/{id}")
	public UserDto deleteUser(@PathParam("id")  Long id);

	@POST
	@Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
	@Path("/update")
	public UserDto update(UserDto userDto);
	
	@POST
	@Produces({MediaType.APPLICATION_JSON}) 
	@Path("/social-network")
	public UserDto getUserForSocialNetwork(UserDto userDto);
	
    @POST
    @Produces({MediaType.APPLICATION_JSON}) 
    @Path("/offer-vehicle/{id}")
    public UserDto offerVehicle (VehicleDto vehicle, @PathParam("id") final Long id);

	@POST
	@Produces({MediaType.APPLICATION_JSON}) 
	@Path("/all-users")
	public List<UserDto> searchUsers();

}
