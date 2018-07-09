package edu.unq.desapp.grupo_a.backend.api;

import edu.unq.desapp.grupo_a.backend.dto.NotificationDto;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/publications")
@Consumes({"application/xml", "application/json"})
@Produces({"application/xml", "application/json"})
public interface NotificationResource {

    @GET
    @Path("/search-all-notifications/{{id}}")
    List<NotificationDto> searchAllNotifications(Long id);
}
