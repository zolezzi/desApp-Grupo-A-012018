package edu.unq.desapp.grupo_a.backend.model;

import java.time.LocalDate;
import java.util.Date;

import edu.unq.desapp.grupo_a.backend.model.exceptions.IllegalRentAccessException;
import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidRentActionException;

public class Rent extends PersistenceEntity {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//http://sites.google.com/site/unqmatematica1
	private User vehicleOwner;
	private Vehicle vehicle;
	private Address withdrawAddress;
	private Address returnAddress;
	private double rentPrice;
	private User renter;
	private Date withdrawDate;
	private Date returnDate;
	private RentState state;

	public Rent(Publication publication, Address returnAddress2, User renter) {
		//check(publication, returnAddress2, renter);
		this.vehicleOwner = publication.getOfferent();
		this.vehicle = publication.getVehicle();
		this.withdrawAddress = publication.getWithdrawAddress();
		this.returnAddress = returnAddress2;
		this.rentPrice = publication.getRentPrice();
		this.renter = renter;
		this.withdrawDate = publication.getStartingDate();
		this.returnDate = publication.getEndingDate();
		this.state = RentState.Initial;
	}

	public User getVehicleOwner() {
		return this.vehicleOwner;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public Address getWithdrawAddress() {
		return this.withdrawAddress;
	}
	
	public Address getReturnAddress() {
		return this.returnAddress;
	}

	public double getRentPrice() {
		return this.rentPrice;
	}

	public User getRenter() {
		return this.renter;
	}

	public Date getWithdrawDate() {
		return this.withdrawDate;
	}

	public Date getReturnDate() {
		return this.returnDate;
	}

    public RentState getState() {
		return this.state;
    }

	public void cancelBy(User anUser) throws IllegalRentAccessException, InvalidRentActionException {
		if (getVehicleOwner() == anUser || getRenter() == anUser) {
			switch (getState()) {
				case Initial:
					this.state = RentState.Canceled;
					break;
				case Canceled:
					break;
				default:
					throw new InvalidRentActionException();
			}
		} else {
			throw new IllegalRentAccessException();
		}
	}

	public void confirmWithdrawBy(User anUser) throws IllegalRentAccessException, InvalidRentActionException {
		if (!getState().userEmail.matches(anUser.getEmail()) &&
				getVehicleOwner() == anUser || getRenter() == anUser) {
			switch (getState()) {
				case WithdrawConfirmed:
					break;
				case WithdrawPreconfirmed:
					this.state = RentState.WithdrawConfirmed;
					break;
				case Initial:
					this.state = RentState.WithdrawPreconfirmed;
					this.state.userEmail = anUser.getEmail();
					break;
				default:
					throw new InvalidRentActionException();
			}
		} else {
			throw new IllegalRentAccessException();
		}
	}

	public void confirmReturnBy(User anUser) throws IllegalRentAccessException, InvalidRentActionException {
		if (!getState().userEmail.matches(anUser.getEmail()) &&
				getVehicleOwner() == anUser || getRenter() == anUser) {
			switch (getState()) {
				case ReturnConfirmed:
					break;
				case ReturnPreconfirmed:
					this.state = RentState.ReturnConfirmed;
					break;
				case WithdrawConfirmed:
					this.state = RentState.ReturnPreconfirmed;
					this.state.userEmail = anUser.getEmail();
					break;
				default:
					throw new InvalidRentActionException();
			}
		} else {
			throw new IllegalRentAccessException();
		}
	}
}
