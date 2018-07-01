package edu.unq.desapp.grupo_a.backend.api;

import edu.unq.desapp.grupo_a.backend.dto.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;

import java.util.List;

public interface PublicationResource {

	@GET
	@Path("/publication/{id}")
	public PublicationDto getPublication(@PathParam("id") Long id);

	@POST
	@Path("/set-publication")
	public void setPublication(PublicationDto publicationDto);

	@POST
    @Path("/update-publication")
    public void updatePublication(PublicationDto publicationDto);

	@DELETE
    @Path("/delete-publication/{id}")
    public void deletePublication(@PathParam("id") Long id);

	@GET
	@Path("/get-user-publications")
	public List<PublicationDto> getUserPublications(Long id);
	
}
