package edu.unq.desapp.grupo_a.backend.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "notifications")
public class Notification extends PersistenceEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @NotNull
    private String message;

    @NotNull
    private long userId;

    public Notification(String message, long userId) {
        this.message = message;
        this.userId = userId;
    }

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
