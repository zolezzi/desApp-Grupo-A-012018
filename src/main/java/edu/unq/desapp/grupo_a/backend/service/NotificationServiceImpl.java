package edu.unq.desapp.grupo_a.backend.service;

import edu.unq.desapp.grupo_a.backend.dto.NotificationDto;
import edu.unq.desapp.grupo_a.backend.repository.NotificationRepository;

import java.util.List;

public class NotificationServiceImpl implements NotificationService {

    private NotificationRepository notificationRepository;

    @Override
    public List<NotificationDto> searchAllNotifications(long idUser) {
        return notificationRepository.searchAllNotifications(idUser);
    }
}
