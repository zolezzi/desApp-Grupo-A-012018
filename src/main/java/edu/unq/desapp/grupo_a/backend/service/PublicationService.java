package edu.unq.desapp.grupo_a.backend.service;

import edu.unq.desapp.grupo_a.backend.model.Publication;

import java.util.List;

public interface PublicationService {
	
	public abstract Publication getPublication(Long id);

	public abstract void setPublication(Publication publication);

	public abstract void updatePublication(Publication publication);

	public abstract void deletePublication(Long id);

	public abstract List<Publication> getUserPublications(Long id);

}
