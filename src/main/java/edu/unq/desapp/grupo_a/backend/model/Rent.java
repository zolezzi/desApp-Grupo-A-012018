package edu.unq.desapp.grupo_a.backend.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import edu.unq.desapp.grupo_a.backend.model.exceptions.IllegalRentAccessException;
import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidRentActionException;
import edu.unq.desapp.grupo_a.backend.utils.JSONDateDeserialize;
import edu.unq.desapp.grupo_a.backend.utils.JSONDateSerialize;

@Table(name="rents")
@Entity
public class Rent extends PersistenceEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	private User vehicleOwner;
	
	@OneToOne	
	private Vehicle vehicle;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address withdrawAddress;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address returnAddress;
	
	@Column(name="rent_price")
	private Double rentPrice;
	
	@OneToOne
	private User renter;
    
	@Temporal(TemporalType.DATE)
	@JsonDeserialize(using = JSONDateDeserialize.class)
	@JsonSerialize(using = JSONDateSerialize.class)
	private Date withdrawDate;

    @Temporal(TemporalType.DATE)
	@JsonDeserialize(using = JSONDateDeserialize.class)
	@JsonSerialize(using = JSONDateSerialize.class)
    private Date returnDate;
	
    @Column(name = "rent_state")
    @Enumerated(EnumType.STRING)
    private RentState state;
    
    public Rent() {
    	
    }
    
	public Rent(Publication publication, Address returnAddress2, User renter) {

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

	public void setVehicleOwner(User vehicleOwner) {
		this.vehicleOwner = vehicleOwner;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void setWithdrawAddress(Address withdrawAddress) {
		this.withdrawAddress = withdrawAddress;
	}

	public void setReturnAddress(Address returnAddress) {
		this.returnAddress = returnAddress;
	}

	public void setRentPrice(Double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public void setRenter(User renter) {
		this.renter = renter;
	}

	public void setWithdrawDate(Date withdrawDate) {
		this.withdrawDate = withdrawDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public void setState(RentState state) {
		this.state = state;
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
