package edu.unq.desapp.grupo_a.backend.arquitecture;

import edu.unq.desapp.grupo_a.backend.model.PersistenceEntity;
import edu.unq.desapp.grupo_a.backend.model.builders.Builder;
import edu.unq.desapp.grupo_a.backend.validators.Validator;
import org.junit.Test;
import org.reflections.Reflections;

import java.util.Set;

public class ArquitectureTest {

    @Test
    public void testEveryPersistenceEntityHasABuilder() {

        Reflections reflections = new Reflections("edu.unq.desapp.grupo_a.backend.model");

        Set<Class<? extends PersistenceEntity>> allPersistenceEntityClasses =
                reflections.getSubTypesOf(PersistenceEntity.class);

        Set<Class<? extends Builder>> allBuilderClasses =
                reflections.getSubTypesOf(Builder.class);

        boolean everyPersistenceEntityHasABuilder = !allPersistenceEntityClasses.isEmpty();

        for (Class<? extends PersistenceEntity> entityClass : allPersistenceEntityClasses) {
            String entityClassName = entityClass.getSimpleName();
            boolean currentEntityHasABuilder = false;
            for (Class<? extends Builder> builderClass : allBuilderClasses) {
                if (currentEntityHasABuilder) {
                    break;
                } else {
                    String builderName = builderClass.getSimpleName();
                    currentEntityHasABuilder = builderName.matches(entityClassName + "Builder");
                }
            }
            if (!currentEntityHasABuilder) {
                everyPersistenceEntityHasABuilder = false;
                break;
            }
        }

        assert everyPersistenceEntityHasABuilder;
    }

    @Test
    public void testEveryPersistenceEntityHasAValidator() {

        Reflections reflections = new Reflections("edu.unq.desapp.grupo_a.backend");

        Set<Class<? extends PersistenceEntity>> allPersistenceEntityClasses =
                reflections.getSubTypesOf(PersistenceEntity.class);

        Set<Class<? extends Validator>> allValidatorClasses =
                reflections.getSubTypesOf(Validator.class);

        boolean everyPersistenceEntityHasAValidator = !allPersistenceEntityClasses.isEmpty();

        for (Class<? extends PersistenceEntity> entityClass : allPersistenceEntityClasses) {
            String entityClassName = entityClass.getSimpleName();
            boolean currentEntityHasAValidator = false;
            for (Class<? extends Validator> validatorClass : allValidatorClasses) {
                if (currentEntityHasAValidator) {
                    break;
                } else {
                    String validatorName = validatorClass.getSimpleName();
                    currentEntityHasAValidator = validatorName.matches(entityClassName + "Validator");
                }
            }
            if (!currentEntityHasAValidator) {
                everyPersistenceEntityHasAValidator = false;
                break;
            }
        }

        assert everyPersistenceEntityHasAValidator;
    }
}
