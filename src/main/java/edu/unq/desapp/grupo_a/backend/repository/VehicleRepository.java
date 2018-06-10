package edu.unq.desapp.grupo_a.backend.repository;

import org.springframework.stereotype.Repository;

import edu.unq.desapp.grupo_a.backend.model.Vehicle;

@Repository
public class VehicleRepository extends HibernateGenericDao<Vehicle> implements GenericDao<Vehicle>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public Class<Vehicle> getDomainClass() {
		return Vehicle.class;
	}

}
