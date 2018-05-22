package edu.unq.desapp.grupo_a.backend.dao;

import org.springframework.stereotype.Repository;

import edu.unq.desapp.grupo_a.backend.model.VehicleData;

@Repository
public class VehicleDataRepository extends HibernateGenericDao<VehicleData> implements GenericDao<VehicleData>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public Class<VehicleData> getDomainClass() {
		
		return VehicleData.class;
	}

}
