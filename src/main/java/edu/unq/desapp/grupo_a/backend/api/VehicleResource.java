package edu.unq.desapp.grupo_a.backend.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.unq.desapp.grupo_a.backend.dto.VehicleDto;
import edu.unq.desapp.grupo_a.backend.dto.VehicleFilterDto;
import edu.unq.desapp.grupo_a.backend.dto.VehicleTypeDto;

@Path("/vehicles")
@Consumes({"application/xml", "application/json"})
@Produces({"application/xml", "application/json"})
public interface VehicleResource {
	
	@POST
	@Produces({MediaType.APPLICATION_JSON}) 
	@Path("/add-vehicle")
	public VehicleDto addVehicle(VehicleDto vehicleDto);
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/get-vehicle/{id}/")
	public VehicleDto getVehicle(@PathParam("id")  Long id);
	
	@PUT
	@Produces({MediaType.APPLICATION_JSON}) 
	@Path("/update-vehicle")
	public VehicleDto updateVehicle(VehicleDto vehicleDto);
	
	@DELETE
	@Path("/remove/{id}/")
	public Response deleteVehicle(@PathParam("id")  Long id);
	
	@POST
	@Produces({MediaType.APPLICATION_JSON}) 
	@Path("/search-vehicle")
	public List<VehicleDto> searchVehicle(VehicleFilterDto vehicleFilterDto);
	
	@GET
	@Consumes("Access : application/xml") 
	@Path("/all-my-vehicles-registered/{id}")
	public List<VehicleDto> allMyVehiclesRegitered(@PathParam("id") final Long id);
	
	@GET
	@Path("/all-type-vehicle")
	public List<VehicleTypeDto> searchAllTypeVehicle();
	


}
