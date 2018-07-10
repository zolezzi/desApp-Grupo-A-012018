package edu.unq.desapp.grupo_a.backend.api;

import edu.unq.desapp.grupo_a.backend.dto.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;

import java.util.List;

@Path("/publications")
@Consumes({"application/xml", "application/json"})
@Produces({"application/xml", "application/json"})
public interface PublicationResource {

	@GET
	@Path("/publication/{id}")
	public PublicationDto getPublication(@PathParam("id") Long id);

	@POST
	@Produces({MediaType.APPLICATION_JSON}) 
	@Path("/set-publication")
	public PublicationDto setPublication(PublicationDto publicationDto);

	@POST
    @Path("/update-publication")
    public void updatePublication(PublicationDto publicationDto);

	@DELETE
    @Path("/delete-publication/{id}")
    public void deletePublication(@PathParam("id") Long id);

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/get-user-publications/{id}")
	public List<PublicationDto> getUserPublications(@PathParam("id") Long id);
	
}
