package edu.unq.desapp.grupo_a.backend.validators;

import java.util.Date;

import edu.unq.desapp.grupo_a.backend.model.Address;
import edu.unq.desapp.grupo_a.backend.model.Availability;
import edu.unq.desapp.grupo_a.backend.model.Publication;
import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.model.Vehicle;
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
                publication.getStartingDate(),
                publication.getEndingDate(),
                publication.getRentPrice());
        Address.check(publication.getWithdrawAddress());
        //Address.check(publication.getReturnAddresses());
        Availability.check(publication);
    }

    private void check(User offerent, Vehicle vehicle, Date startingDate, Date endingDate, double rentPrice)
            throws WrongPublicationException {
        if (    offerent == null || vehicle == null ||
                !offerent.getVehicles().contains(vehicle) ||
                startingDate == null ||
                endingDate == null ||
                endingDate.before(startingDate) ||
                rentPrice <= 0) {
            throw new WrongPublicationException("Publicación inválida");
        }
    }
}
