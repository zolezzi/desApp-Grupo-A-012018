package edu.unq.desapp.grupo_a.backend.validators;

import edu.unq.desapp.grupo_a.backend.model.*;
import edu.unq.desapp.grupo_a.backend.model.exceptions.WrongPublicationException;

public class PublicationValidator extends Validator {

    @Override
    public void validate(Object object) throws ExceptionInInitializerError {
        Publication publication = (Publication) object;
        validatePublication(publication);
    }

    private void validatePublication(Publication publication) {
        check(  publication.getOfferent(),
                publication.getVehicle(),
                publication.getAvailability(),
                publication.getRentPrice());
        Address.check(publication.getWithdrawAddress());
        Address.check(publication.getReturnAddresses());
    }

    private void check(User offerent, Vehicle vehicle, Availability availability, double rentPrice)
            throws WrongPublicationException {
        if (offerent == null || vehicle == null ||
                !offerent.getVehicles().contains(vehicle) ||
                availability == null || rentPrice <= 0) {
            throw new WrongPublicationException();
        }
    }
}
