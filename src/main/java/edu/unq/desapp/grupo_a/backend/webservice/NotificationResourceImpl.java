package edu.unq.desapp.grupo_a.backend.webservice;

import edu.unq.desapp.grupo_a.backend.api.NotificationResource;
import edu.unq.desapp.grupo_a.backend.dto.NotificationDto;
import edu.unq.desapp.grupo_a.backend.service.NotificationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Service
@Produces("application/json")
@Consumes("application/json")
@Path("/notifications")
public class NotificationResourceImpl implements NotificationResource {

    private NotificationService notificationService;

    @Override
    public List<NotificationDto> searchAllNotifications(Long id) {

        return notificationService.searchAllNotifications(id);
    }
}
