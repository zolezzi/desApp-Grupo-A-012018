package edu.unq.desapp.grupo_a.backend.model.builders;

import edu.unq.desapp.grupo_a.backend.model.PersistenceEntity;
import edu.unq.desapp.grupo_a.backend.model.exceptions.WrongValidatorException;
import edu.unq.desapp.grupo_a.backend.validators.Validator;


public abstract class Builder<PE extends PersistenceEntity> {

    public final PE build() throws ExceptionInInitializerError {
        PE object = fireBuild();
        Class<?> objectClass = object.getClass();

        try {
            String className = objectClass.getSimpleName();
            //Obtengo la clase del Validator correspondiente para el object
            Class<?> validatorClass = Class.forName("edu.unq.desapp.grupo_a.backend.validators." + className + "Validator");
            //Obtengo un Validator
            Validator validator = (Validator) validatorClass.newInstance();
            //Valido el objeto
            validator.validate(object);
        } catch ( ClassNotFoundException
                | InstantiationException
                | IllegalAccessException e) {
            throw new WrongValidatorException(e);
        }

        return object;
    }

    protected abstract PE fireBuild();
}
