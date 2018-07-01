package edu.unq.desapp.grupo_a.backend.validators;

import edu.unq.desapp.grupo_a.backend.model.*;
import edu.unq.desapp.grupo_a.backend.model.exceptions.WrongPublicationException;

import java.time.LocalDate;

public class PublicationValidator extends Validator {

    @Override
    public void validate(Object object) throws ExceptionInInitializerError {
        Publication publication = (Publication) object;
        validatePublication(publication);
    }

    private void validatePublication(Publication publication) {
        check(  publication.getOfferent(),
                publication.getVehicle(),
                publication.getStartingDate(),
                publication.getEndingDate(),
                publication.getRentPrice());
        Address.check(publication.getWithdrawAddress());
        Address.check(publication.getReturnAddresses());
        Availability.check(publication);
    }

    private void check(User offerent, Vehicle vehicle, LocalDate startingDate, LocalDate endingDate, double rentPrice)
            throws WrongPublicationException {
        if (    offerent == null || vehicle == null ||
                !offerent.getVehicles().contains(vehicle) ||
                startingDate == null ||
                endingDate == null ||
                endingDate.isBefore(startingDate) ||
                rentPrice <= 0) {
            throw new WrongPublicationException();
        }
    }
}
