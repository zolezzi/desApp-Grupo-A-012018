package edu.unq.desapp.grupo_a.backend.service;

import org.springframework.stereotype.Service;

import edu.unq.desapp.grupo_a.backend.model.Publication;
import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.repository.PublicationRepository;
import edu.unq.desapp.grupo_a.backend.validators.PublicationValidator;

import java.util.List;

@Service
public class PublicationServiceImpl implements PublicationService{

	private PublicationValidator publicationValidator;
	private PublicationRepository publicationRepository;

	@Override
	public Publication getPublication(Long id) {

		return publicationRepository.findById(id);
	}

	@Override
	public void setPublication(Publication publication) {
		publicationValidator.validate(publication);
		publicationRepository.save(publication);
	}

	@Override
    public void updatePublication(Publication publication) {
	    publicationValidator.validate(publication);
	    publicationRepository.update(publication);
    }

    @Override
    public void deletePublication(Long id) {
	    Publication publication = publicationRepository.findById(id);

	    if(publication != null) {
            publicationRepository.delete(publication);
        }
    }

	@Override
    public List<Publication> getUserPublications(Long id) {

		return publicationRepository.findBy("offerent", Long.toString(id));
	}

}
