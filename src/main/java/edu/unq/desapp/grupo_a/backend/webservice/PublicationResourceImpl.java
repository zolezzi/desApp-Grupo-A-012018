package edu.unq.desapp.grupo_a.backend.webservice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unq.desapp.grupo_a.backend.api.PublicationResource;
import edu.unq.desapp.grupo_a.backend.dto.PublicationDto;
import edu.unq.desapp.grupo_a.backend.model.Publication;
import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.model.Vehicle;
import edu.unq.desapp.grupo_a.backend.repository.PublicationRepository;
import edu.unq.desapp.grupo_a.backend.service.PublicationService;
import edu.unq.desapp.grupo_a.backend.service.UserService;
import edu.unq.desapp.grupo_a.backend.service.VehicleService;

@Service
@Produces("application/json")
@Consumes("application/json")
@Path("/publications")
public class PublicationResourceImpl implements PublicationResource {

	private PublicationService publicationService;
	
	private UserService userService;
	
	private VehicleService vehicleService;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public PublicationDto getPublication(Long id) {

		Publication publication = publicationService.getPublication(id);

		return modelMapper.map(publication, PublicationDto.class);
	}

	@Override
	@Transactional(readOnly = false)
	public PublicationDto setPublication(PublicationDto publicationDto) {
		
		User user = userService.getUser(publicationDto.getUserOfferentId());
		Vehicle vehicle = vehicleService.getVehicle(publicationDto.getVehicleId());
		
		Publication publication = modelMapper.map(publicationDto, Publication.class);
		//Publication publication = new Publication();
		publication.setOfferent(user);
		publication.setVehicle(vehicle);
		
		publicationService.setPublication(publication);
		
		return publicationDto;
	}

    @Override
    public void updatePublication(PublicationDto publicationDto) {

	    Publication publication = modelMapper.map(publicationDto, Publication.class);

	    publicationService.updatePublication(publication);
    }

    @Override
    public void deletePublication(Long id) {

	    publicationService.deletePublication(id);
    }

	@Override
	@Transactional(readOnly = false)
    public List<PublicationDto> getUserPublications(Long id) {

	    List<Publication> userPublications = publicationService.getUserPublications(id);
//	    List<PublicationDto> userPublicationsDtos = new ArrayList<>();
//
//	    for (Publication publication : userPublications) {
//	        PublicationDto publicationDto = modelMapper.map(publication, PublicationDto.class);
//	        userPublicationsDtos.add(publicationDto);
//        }
	    
	    return userPublications.stream().map(publication -> publication.toDto()).collect(Collectors.toList());

		//return userPublicationsDtos;
	}

	public PublicationService getPublicationService() {
		return publicationService;
	}

	public void setPublicationService(PublicationService publicationService) {
		this.publicationService = publicationService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public VehicleService getVehicleService() {
		return vehicleService;
	}

	public void setVehicleService(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

	@Override
	@Transactional(readOnly=false)
	public List<PublicationDto> getallPublications() {
		
		List<Publication> publications = publicationService.getAllPublications();
				
		return publications.stream().map(publication -> publication.toDto()).collect(Collectors.toList());
	}
}
