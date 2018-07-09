package edu.unq.desapp.grupo_a.backend.model.builders;

import edu.unq.desapp.grupo_a.backend.dto.NotificationDto;
import edu.unq.desapp.grupo_a.backend.model.Notification;

import java.util.ArrayList;
import java.util.List;

public class NotificationBuilder extends Builder {

    private String message = "Mensaje de prueba";

    private long userId = 0;

    public static List<NotificationDto> toDto(List<Notification> notificationList) {
        List<NotificationDto> result = new ArrayList<>();

        for (Notification notification : notificationList) {
            NotificationDto notificationDto = new NotificationDto();
            notificationDto.setUserId(notification.getUserId());
            notificationDto.setMessage(notification.getMessage());
            result.add(notificationDto);
        }

        return result;
    }

    @Override
    protected Notification fireBuild() {
        return new Notification(message, userId);
    }

    public NotificationBuilder aNotification() {
        return new NotificationBuilder();
    }

    public NotificationBuilder withMessage(String aMessage) {
        this.message = aMessage;
        return this;
    }

    public NotificationBuilder withUserId(long anUserId) {
        this.userId = anUserId;
        return this;
    }
}
