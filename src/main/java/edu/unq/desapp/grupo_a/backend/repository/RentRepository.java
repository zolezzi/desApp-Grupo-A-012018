package edu.unq.desapp.grupo_a.backend.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.unq.desapp.grupo_a.backend.model.Rent;
import edu.unq.desapp.grupo_a.backend.model.User;

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
		return Rent.class;
	}
	
	public List<Rent> findAllRents(Long id) {
		
		List<Rent> queryResult = new ArrayList<>();

		String hql = "SELECT rent FROM Rent as rent" +
				" where rent.renter.id = :id";
		Query query = this.getSessionFactory().getCurrentSession().createQuery(hql);		
		query.setParameter("id", id);

		queryResult = query.list();
		
		if(queryResult.isEmpty()){
			return null;
		}
		
		
		return queryResult;

	}
	
	public List<Rent> findAllRentsByVehicleOwner(Long id) {
		
		List<Rent> queryResult = new ArrayList<>();

		String hql = "SELECT rent FROM Rent as rent" +
				" where rent.vehicleOwner.id = :id";
		Query query = this.getSessionFactory().getCurrentSession().createQuery(hql);		
		query.setParameter("id", id);

		queryResult = query.list();
		
		if(queryResult.isEmpty()){
			return null;
		}
		
		
		return queryResult;

	}

}
