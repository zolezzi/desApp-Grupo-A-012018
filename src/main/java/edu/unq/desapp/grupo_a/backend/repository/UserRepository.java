package edu.unq.desapp.grupo_a.backend.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import edu.unq.desapp.grupo_a.backend.model.User;

@Repository
public class UserRepository extends HibernateGenericDao<User> implements GenericDao<User> {

	private static final long serialVersionUID = -4425722631916607857L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public Class<User> getDomainClass() {
		return User.class;
	}
	
	public User findByIdSocialNetwork(String facebookId, String googleId) {
		
		List<User> queryResult = new ArrayList<>();

		String hql = "SELECT user FROM User as user" +
				" where user.idGoogle = :googleId" +
				" or user.idFacebook = :facebookId";
		Query query = this.getSessionFactory().getCurrentSession().createQuery(hql);		
		query.setParameter("googleId", googleId);
		query.setParameter("facebookId", facebookId);
		
		queryResult = query.list();
		
		if(queryResult.isEmpty()){
			return null;
		}
		
		
		return queryResult.get(0);

	}
}
