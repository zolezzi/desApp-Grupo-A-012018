package edu.unq.desapp.grupo_a.backend.dao;

import org.springframework.stereotype.Repository;

import edu.unq.desapp.grupo_a.backend.model.Rent;

@Repository
public class RentRepository extends HibernateGenericDao<Rent> implements GenericDao<Rent>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public Class<Rent> getDomainClass() {
		// TODO Auto-generated method stub
		return null;
	}

}
