package edu.unq.desapp.grupo_a.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.unq.desapp.grupo_a.backend.model.Publication;
import edu.unq.desapp.grupo_a.backend.repository.PublicationRepository;
import edu.unq.desapp.grupo_a.backend.validators.PublicationValidator;

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

		return publicationRepository.findByUserOfferent(id);
	}

	public PublicationValidator getPublicationValidator() {
		return publicationValidator;
	}

	public void setPublicationValidator(PublicationValidator publicationValidator) {
		this.publicationValidator = publicationValidator;
	}

	public PublicationRepository getPublicationRepository() {
		return publicationRepository;
	}

	public void setPublicationRepository(PublicationRepository publicationRepository) {
		this.publicationRepository = publicationRepository;
	}

}
