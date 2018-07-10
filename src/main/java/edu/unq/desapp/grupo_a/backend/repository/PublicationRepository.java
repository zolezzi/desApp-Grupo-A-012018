package edu.unq.desapp.grupo_a.backend.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
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
		return Publication.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Publication> findByUserOfferent(Long userId) {
		
		List<Publication> queryResult = new ArrayList<>();

		String hql = "SELECT publication FROM Publication as publication" +
				" where publication.offerent.id = :userId";
		Query query = this.getSessionFactory().getCurrentSession().createQuery(hql);		
		query.setParameter("userId", userId);
		
		queryResult = query.list();
		
		if(queryResult.isEmpty()){
			return null;
		}
		
		
		return queryResult;

	}

}
