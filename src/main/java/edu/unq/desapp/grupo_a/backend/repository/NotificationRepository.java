package edu.unq.desapp.grupo_a.backend.repository;

import edu.unq.desapp.grupo_a.backend.dto.NotificationDto;
import edu.unq.desapp.grupo_a.backend.model.Notification;
import edu.unq.desapp.grupo_a.backend.model.builders.NotificationBuilder;
import org.hibernate.Query;

import java.util.List;

public class NotificationRepository extends HibernateGenericDao<Notification> implements GenericDao<Notification> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public Class<Notification> getDomainClass() {
        return Notification.class;
    }

    public List<NotificationDto> searchAllNotifications(long idUser) {
        List<Notification> queryResult;

        String hql = "notification FROM notifications" +
                " where notification.userId = :idUser";
        Query query = this.getSessionFactory().getCurrentSession().createQuery(hql);
        query.setParameter("idUser", idUser);

        queryResult = query.list();

        if(queryResult.isEmpty()){
            return null;
        }

        return NotificationBuilder.toDto(queryResult);
    }
}
