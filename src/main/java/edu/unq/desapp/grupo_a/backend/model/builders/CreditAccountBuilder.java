package edu.unq.desapp.grupo_a.backend.model.builders;

import edu.unq.desapp.grupo_a.backend.model.CreditAccount;

public class CreditAccountBuilder extends Builder {

    @Override
    protected CreditAccount fireBuild() {
        return new CreditAccount();
    }
}
