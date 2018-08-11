package edu.unq.desapp.grupo_a.backend.model.exceptions;

public abstract class InitializerException extends ExceptionInInitializerError {

    private String message;

    InitializerException(String message) {
        this.message = message;
    }

    public String getMessage() {
        if (this.message == null) {
            this.message = "Error en la inicialización de los datos del objeto";
        }
        return this.message;
    }
}
