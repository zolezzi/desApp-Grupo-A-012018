package edu.unq.desapp.grupo_a.backend.model.builders;

import edu.unq.desapp.grupo_a.backend.model.Phone;

public class PhoneBuilder extends Builder {

    @Override
    protected Phone fireBuild() {
        return new Phone();
    }
}
