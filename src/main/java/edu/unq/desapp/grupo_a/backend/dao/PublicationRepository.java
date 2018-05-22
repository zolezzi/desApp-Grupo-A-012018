package edu.unq.desapp.grupo_a.backend.dao;

import org.springframework.stereotype.Repository;

import edu.unq.desapp.grupo_a.backend.model.Publication;

@Repository
public class PublicationRepository extends HibernateGenericDao<Publication> implements GenericDao<Publication>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 125013299983424970L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public Class<Publication> getDomainClass() {
		// TODO Auto-generated method stub
		return null;
	}

}
