package edu.unq.desapp.grupo_a.backend.service;

import edu.unq.desapp.grupo_a.backend.dto.NotificationDto;

import java.util.List;

public interface NotificationService {

    public List<NotificationDto> searchAllNotifications(long idUser);
}
