package edu.unq.desapp.grupo_a.backend.model;

import edu.unq.desapp.grupo_a.backend.model.builders.PublicationBuilder;
import edu.unq.desapp.grupo_a.backend.model.builders.RentBuilder;
import edu.unq.desapp.grupo_a.backend.model.builders.UserBuilder;
import edu.unq.desapp.grupo_a.backend.model.exceptions.IllegalRentAccessException;
import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidActionException;
import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidRentActionException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RentActionsTest {

    private User vehicleOwner;
    private User renter;
    private Rent aRent;
    private User aNonRelatedUser;

    @Before
    public void setUp() {
        vehicleOwner = (User) UserBuilder.anUser()
                .withEmail("vehicle.owner@email.com")
                .build();

        Publication aPublication = (Publication) PublicationBuilder.aPublication()
                .withOfferent(vehicleOwner)
                .addVehicle()
                .build();

        renter = (User) UserBuilder.anUser()
                .withEmail("renter@email.com")
                .build();
        renter.setId((long) 0);

        aRent = (Rent) RentBuilder.aRent()
                .fromPublication(aPublication)
                .withRenter(renter)
                .build();

        aNonRelatedUser = (User) UserBuilder.anUser()
                .build();
    }

    @Test
    public void testNewRentHasAnInitialState() {
        assertEquals(RentState.Initial, aRent.getState());
    }

    @Test
    public void testCancelRentByRenter() throws InvalidActionException {
        aRent.cancelBy(renter);

        assertEquals(RentState.Canceled, aRent.getState());
    }

    @Test
    public void testCancelRentByVehicleOwner() throws InvalidActionException {
        aRent.cancelBy(vehicleOwner);

        assertEquals (RentState.Canceled, aRent.getState());
    }

    @Test (expected = IllegalRentAccessException.class)
    public void testCancelRentByANonRelatedUser() throws InvalidActionException {
        aRent.cancelBy(aNonRelatedUser);
    }

    @Test (expected = IllegalRentAccessException.class)
    public void testConfirmWithdrawByANonRelatedUser() throws InvalidActionException {
        aRent.confirmWithdrawBy(aNonRelatedUser);
    }

    @Test (expected = InvalidRentActionException.class)
    public void testPreconfirmWithdrawOfACanceledRent () throws InvalidActionException {
        aRent.cancelBy(vehicleOwner);
        aRent.confirmWithdrawBy(renter);
    }

    @Test (expected = InvalidRentActionException.class)
    public void testCancelAPreconfirmedWithdrawRent () throws InvalidActionException {
        aRent.confirmWithdrawBy(renter);
        aRent.cancelBy(vehicleOwner);
    }

    @Test (expected = InvalidRentActionException.class)
    public void testCancelAConfirmedWithdrawRent() throws InvalidActionException {
        aRent.confirmWithdrawBy(renter);
        aRent.confirmWithdrawBy(vehicleOwner);
        aRent.cancelBy(vehicleOwner);
    }

    @Test
    public void testCancelACanceledRent() throws InvalidActionException {
        aRent.cancelBy(renter);
        aRent.cancelBy(vehicleOwner);

        assertEquals(RentState.Canceled, aRent.getState());
    }

    @Test (expected = InvalidRentActionException.class)
    public void testConfirmReturnInAPreConfirmedWithdrawRent() throws InvalidActionException {
        aRent.confirmWithdrawBy(vehicleOwner);
        aRent.confirmReturnBy(renter);
    }

    @Test (expected = InvalidRentActionException.class)
    public void testConfirmReturnInACanceledRent() throws InvalidActionException {
        aRent.cancelBy(vehicleOwner);
        aRent.confirmReturnBy(renter);
    }

    @Test (expected = InvalidRentActionException.class)
    public void testConfirmReturnInANewRent() throws InvalidActionException {
        aRent.confirmReturnBy(renter);
    }

    @Test (expected = InvalidRentActionException.class)
    public void testCancelAPreConfirmedReturnedRent() throws InvalidActionException {
        aRent.confirmWithdrawBy(vehicleOwner);
        aRent.confirmWithdrawBy(renter);
        aRent.confirmReturnBy(renter);
        aRent.cancelBy(vehicleOwner);
    }

    @Test (expected = InvalidRentActionException.class)
    public void testCancelAConfirmedReturnedRent() throws InvalidActionException {
        aRent.confirmWithdrawBy(renter);
        aRent.confirmWithdrawBy(vehicleOwner);
        aRent.confirmReturnBy(vehicleOwner);
        aRent.confirmReturnBy(renter);
        aRent.cancelBy(vehicleOwner);
    }

    @Test (expected = InvalidRentActionException.class)
    public void testConfirmWithdrawInAPreConfirmedReturnedRent() throws InvalidActionException {
        aRent.confirmWithdrawBy(vehicleOwner);
        aRent.confirmWithdrawBy(renter);
        aRent.confirmReturnBy(renter);
        aRent.confirmWithdrawBy(vehicleOwner);
    }

    @Test (expected = InvalidRentActionException.class)
    public void testConfirmWithdrawInAConfirmedReturnedRent() throws InvalidActionException {
        aRent.confirmWithdrawBy(renter);
        aRent.confirmWithdrawBy(vehicleOwner);
        aRent.confirmReturnBy(vehicleOwner);
        aRent.confirmReturnBy(renter);
        aRent.confirmWithdrawBy(vehicleOwner);
    }
}
