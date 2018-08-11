package edu.unq.desapp.grupo_a.backend.validators;

import edu.unq.desapp.grupo_a.backend.model.Notification;
import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidNotificationException;

public class NotificationValidator extends Validator {

    @Override
    public void validate(Object object) throws InvalidNotificationException {
        Notification notification = (Notification) object;
        validateNotification(notification);
    }

    private void validateNotification(Notification notification) {
        validateNotificationMessage(notification.getMessage());
    }

    private void validateNotificationMessage(String message) {
        if (null == message || message.isEmpty()) {
            throw new InvalidNotificationException("El mensaje de notificación no puede estar vacío.");
        }
    }
}
