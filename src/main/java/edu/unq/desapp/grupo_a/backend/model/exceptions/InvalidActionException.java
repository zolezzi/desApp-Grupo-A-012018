package edu.unq.desapp.grupo_a.backend.model.exceptions;

public abstract class InvalidActionException extends IllegalAccessException {

    private String message;

    InvalidActionException(String message) {
        this.message = message;
    }

    public String getMessage() {
        if (this.message == null) {
            this.message = "Acción inválida";
        }
        return this.message;
    }
}
