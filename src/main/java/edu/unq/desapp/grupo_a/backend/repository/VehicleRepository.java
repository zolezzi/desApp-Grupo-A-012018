package edu.unq.desapp.grupo_a.backend.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.model.Vehicle;
import edu.unq.desapp.grupo_a.backend.model.VehicleFilter;

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
	
	public List<Vehicle> searchVehicle(VehicleFilter vehicleFilter){
		List<Vehicle> queryResult = new ArrayList<>();

		String hql = "vehicle user FROM Vehicle as vehicle" +
				" where vehicle.fromDate >= :fromDate" +
				" or vehicle.toDate <= :toDate";
		Query query = this.getSessionFactory().getCurrentSession().createQuery(hql);		
		query.setParameter("fromDate", vehicleFilter.getFromDate());
		query.setParameter("toDate", vehicleFilter.getToDate());
		
		queryResult = query.list();
		
		if(queryResult.isEmpty()){
			return null;
		}
		
		
		return queryResult;

	}

}
