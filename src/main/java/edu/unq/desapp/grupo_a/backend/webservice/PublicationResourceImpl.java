package edu.unq.desapp.grupo_a.backend.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import edu.unq.desapp.grupo_a.backend.dto.*;
import edu.unq.desapp.grupo_a.backend.model.Publication;
import edu.unq.desapp.grupo_a.backend.service.PublicationService;
import edu.unq.desapp.grupo_a.backend.service.UserService;
import edu.unq.desapp.grupo_a.backend.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import edu.unq.desapp.grupo_a.backend.api.PublicationResource;

@Service
@Produces("application/json")
@Consumes("application/json")
@Path("/publications")
public class PublicationResourceImpl implements PublicationResource {

	private PublicationService publicationService;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public PublicationDto getPublication(Long id) {

		Publication publication = publicationService.getPublication(id);

		return modelMapper.map(publication, PublicationDto.class);
	}

	@Override
	public void setPublication(PublicationDto publicationDto) {

		Publication publication = modelMapper.map(publicationDto, Publication.class);

		publicationService.setPublication(publication);
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
    public List<PublicationDto> getUserPublications(Long id) {

	    List<Publication> userPublications = publicationService.getUserPublications(id);
	    List<PublicationDto> userPublicationsDtos = new ArrayList<>();

	    for (Publication publication : userPublications) {
	        PublicationDto publicationDto = modelMapper.map(publication, PublicationDto.class);
	        userPublicationsDtos.add(publicationDto);
        }

		return userPublicationsDtos;
	}
}
