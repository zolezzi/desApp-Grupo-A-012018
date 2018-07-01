package edu.unq.desapp.grupo_a.backend.model.builders;

import edu.unq.desapp.grupo_a.backend.model.Photo;

public class PhotoBuilder extends Builder {

    @Override
    protected Photo fireBuild() {
        return new Photo();
    }
}
