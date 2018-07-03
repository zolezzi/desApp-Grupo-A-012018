package edu.unq.desapp.grupo_a.backend.model;

import edu.unq.desapp.grupo_a.backend.model.builders.PublicationBuilder;
import edu.unq.desapp.grupo_a.backend.model.builders.RentBuilder;
import edu.unq.desapp.grupo_a.backend.model.builders.UserBuilder;
import edu.unq.desapp.grupo_a.backend.model.exceptions.IllegalRentAccessException;
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
    public void testCancelRentByRenter() throws IllegalRentAccessException, InvalidRentActionException {
        aRent.cancelBy(renter);

        assertEquals(RentState.Canceled, aRent.getState());
    }

    @Test
    public void testCancelRentByVehicleOwner() throws IllegalRentAccessException, InvalidRentActionException {
        aRent.cancelBy(vehicleOwner);

        assertEquals (RentState.Canceled, aRent.getState());
    }

    @Test (expected = IllegalRentAccessException.class)
    public void testCancelRentByANonRelatedUser() throws IllegalRentAccessException, InvalidRentActionException {
        aRent.cancelBy(aNonRelatedUser);
    }

    @Test
    public void testRentConfirmWithdrawOnlyByRenter() throws IllegalRentAccessException, InvalidRentActionException {
        aRent.confirmWithdrawBy(renter);

        assertEquals(RentState.WithdrawPreconfirmed, aRent.getState());
    }

    @Test
    public void testRentConfirmWithdrawOnlyByVehicleOwner() throws IllegalRentAccessException, InvalidRentActionException {
        aRent.confirmWithdrawBy(vehicleOwner);

        assertEquals(RentState.WithdrawPreconfirmed, aRent.getState());
    }

    @Test (expected = IllegalRentAccessException.class)
    public void testConfirmWithdrawByANonRelatedUser() throws IllegalRentAccessException, InvalidRentActionException {
        aRent.confirmWithdrawBy(aNonRelatedUser);
    }

    @Test (expected = InvalidRentActionException.class)
    public void testPreconfirmWithdrawOfACanceledRent () throws IllegalRentAccessException, InvalidRentActionException {
        aRent.cancelBy(vehicleOwner);
        aRent.confirmWithdrawBy(renter);
    }

    @Test (expected = InvalidRentActionException.class)
    public void testCancelAPreconfirmedWithdrawRent () throws IllegalRentAccessException, InvalidRentActionException {
        aRent.confirmWithdrawBy(renter);
        aRent.cancelBy(vehicleOwner);
    }

    @Test
    public void testConfirmWithdrawByThe2Users() throws IllegalRentAccessException, InvalidRentActionException {
        aRent.confirmWithdrawBy(vehicleOwner);
        aRent.confirmWithdrawBy(renter);

        assertEquals(RentState.WithdrawConfirmed, aRent.getState());
    }

    @Test (expected = IllegalRentAccessException.class)
    public void testConfirmWithdraw2TimesByTheSameUser() throws IllegalRentAccessException, InvalidRentActionException {
        aRent.confirmWithdrawBy(vehicleOwner);
        aRent.confirmWithdrawBy(vehicleOwner);
    }

    @Test (expected = InvalidRentActionException.class)
    public void testCancelAConfirmedWithdrawRent() throws IllegalRentAccessException, InvalidRentActionException {
        aRent.confirmWithdrawBy(renter);
        aRent.confirmWithdrawBy(vehicleOwner);
        aRent.cancelBy(vehicleOwner);
    }

    @Test
    public void testCancelACanceledRent() throws IllegalRentAccessException, InvalidRentActionException {
        aRent.cancelBy(renter);
        aRent.cancelBy(vehicleOwner);

        assertEquals(RentState.Canceled, aRent.getState());
    }

    @Test
    public void testPreConfirmReturnInAConfirmedWithdrawRent() throws IllegalRentAccessException, InvalidRentActionException {
        aRent.confirmWithdrawBy(renter);
        aRent.confirmWithdrawBy(vehicleOwner);
        aRent.confirmReturnBy(renter);

        assertEquals(RentState.ReturnPreconfirmed, aRent.getState());
    }

    @Test (expected = InvalidRentActionException.class)
    public void testConfirmReturnInAPreConfirmedWithdrawRent() throws IllegalRentAccessException, InvalidRentActionException {
        aRent.confirmWithdrawBy(vehicleOwner);
        aRent.confirmReturnBy(renter);
    }

    @Test (expected = InvalidRentActionException.class)
    public void testConfirmReturnInACanceledRent() throws IllegalRentAccessException, InvalidRentActionException {
        aRent.cancelBy(vehicleOwner);
        aRent.confirmReturnBy(renter);
    }

    @Test (expected = InvalidRentActionException.class)
    public void testConfirmReturnInANewRent() throws IllegalRentAccessException, InvalidRentActionException {
        aRent.confirmReturnBy(renter);
    }

    @Test
    public void testConfirmReturnInAPreConfirmedReturnedRent() throws IllegalRentAccessException, InvalidRentActionException {
        aRent.confirmWithdrawBy(vehicleOwner);
        aRent.confirmWithdrawBy(renter);
        aRent.confirmReturnBy(vehicleOwner);
        aRent.confirmReturnBy(renter);

        assertEquals(RentState.ReturnConfirmed, aRent.getState());
    }

    /*
    @Test (expected = IllegalRentAccessException.class)

    public void testConfirmReturn2TimesByTheSameUser() throws IllegalRentAccessException, InvalidRentActionException {
        aRent.confirmWithdrawBy(vehicleOwner);
        aRent.confirmWithdrawBy(renter);
        aRent.confirmReturnBy(renter);
        aRent.confirmReturnBy(renter);
    }
    */

    @Test
    public void testConfirmWithdrawInAnAlreadyConfirmedWithdrawRent() throws IllegalRentAccessException, InvalidRentActionException {
        aRent.confirmWithdrawBy(vehicleOwner);
        aRent.confirmWithdrawBy(renter);
        aRent.confirmWithdrawBy(vehicleOwner);

        assertEquals(RentState.WithdrawConfirmed, aRent.getState());
    }

    @Test
    public void testConfirmReturnInAnAlreadyConfirmedReturnedRent() throws IllegalRentAccessException, InvalidRentActionException {
        aRent.confirmWithdrawBy(vehicleOwner);
        aRent.confirmWithdrawBy(renter);
        aRent.confirmReturnBy(vehicleOwner);
        aRent.confirmReturnBy(renter);
        aRent.confirmReturnBy(vehicleOwner);

        assertEquals(RentState.ReturnConfirmed, aRent.getState());
    }

    @Test (expected = InvalidRentActionException.class)
    public void testCancelAPreConfirmedReturnedRent() throws IllegalRentAccessException, InvalidRentActionException {
        aRent.confirmWithdrawBy(vehicleOwner);
        aRent.confirmWithdrawBy(renter);
        aRent.confirmReturnBy(renter);
        aRent.cancelBy(vehicleOwner);
    }

    @Test (expected = InvalidRentActionException.class)
    public void testCancelAConfirmedReturnedRent() throws IllegalRentAccessException, InvalidRentActionException {
        aRent.confirmWithdrawBy(renter);
        aRent.confirmWithdrawBy(vehicleOwner);
        aRent.confirmReturnBy(vehicleOwner);
        aRent.confirmReturnBy(renter);
        aRent.cancelBy(vehicleOwner);
    }

    @Test (expected = InvalidRentActionException.class)
    public void testConfirmWithdrawInAPreConfirmedReturnedRent() throws IllegalRentAccessException, InvalidRentActionException {
        aRent.confirmWithdrawBy(vehicleOwner);
        aRent.confirmWithdrawBy(renter);
        aRent.confirmReturnBy(renter);
        aRent.confirmWithdrawBy(vehicleOwner);
    }

    @Test (expected = InvalidRentActionException.class)
    public void testConfirmWithdrawInAConfirmedReturnedRent() throws IllegalRentAccessException, InvalidRentActionException {
        aRent.confirmWithdrawBy(renter);
        aRent.confirmWithdrawBy(vehicleOwner);
        aRent.confirmReturnBy(vehicleOwner);
        aRent.confirmReturnBy(renter);
        aRent.confirmWithdrawBy(vehicleOwner);
    }
}
