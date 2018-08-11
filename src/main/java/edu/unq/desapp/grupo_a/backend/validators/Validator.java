package edu.unq.desapp.grupo_a.backend.validators;

import edu.unq.desapp.grupo_a.backend.model.exceptions.InitializerException;

public abstract class Validator {

    public abstract void validate(Object object) throws InitializerException;
}
