package edu.unq.desapp.grupo_a.backend.dto;

public class NotificationDto {

    private String message;

    private long userId;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
