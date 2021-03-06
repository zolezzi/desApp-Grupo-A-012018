package edu.unq.desapp.grupo_a.backend.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidActionException;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import edu.unq.desapp.grupo_a.backend.dto.RentDto;
import edu.unq.desapp.grupo_a.backend.model.exceptions.IllegalRentAccessException;
import edu.unq.desapp.grupo_a.backend.model.exceptions.InvalidRentActionException;

import edu.unq.desapp.grupo_a.backend.utils.JSONDateDeserialize;
import edu.unq.desapp.grupo_a.backend.utils.JSONDateSerialize;

import edu.unq.desapp.grupo_a.backend.utils.EmailUtil;

import java.util.ArrayList;
import java.util.List;

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
    
    @ManyToOne
    private Publication publication;
    
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
	
	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	public RentDto toDto() {

		RentDto rentDto = new RentDto();
		rentDto.setId(getId());
		rentDto.setAddressDto(getReturnAddress().toDto());
		rentDto.setPublicationId(getPublication().getId());
		rentDto.setRenterId(getRenter().getId());
		rentDto.setUserRenterName(getRenter().getName());
		rentDto.setUserId(getVehicleOwner().getId());
		rentDto.setState(getState().description);
		rentDto.setBrand(getVehicle().getBrand());
		rentDto.setModel(getVehicle().getModel());
		rentDto.setUserName(getVehicleOwner().getName() + " - " + getVehicleOwner().getLastName() );
		rentDto.setRentPrice(getPublication().getRentPrice());
		rentDto.setStartingDate(getPublication().getStartingDate());
		rentDto.setEndingDate(getPublication().getEndingDate());
		
		return rentDto;
	}
	
	public void pendingBy(User anUser) throws InvalidActionException {
		if (getVehicleOwner() == anUser || getRenter() == anUser) {
			switch (getState()) {
				case Pending:
					this.state = RentState.Pending;
					List<User> toEmails = new ArrayList<>();
					toEmails.add(getVehicleOwner());
					toEmails.add(getRenter());
					EmailUtil.sendEmails(toEmails, "Renta Pendiente",
						"Le informamos que la renta del vehículo " + getVehicle().getBrand() + " " +
						getVehicle().getModel() + " para los días " + getWithdrawDate() + " al " + getReturnDate() +
						" ha sido reservado por " + anUser.getName() + " " + anUser.getLastName() + ".\n" +
						"Esperamos la confirmacion. El equipo de CARPND está para ayudarle.");
					break;
				case Canceled:
					break;
				default:
					throw new InvalidRentActionException("No se puede dejar pendiente una renta en el estado actual de la misma.");
			}
		} else {
			throw new IllegalRentAccessException("Usted no está autorizado para rentar dicho vehículo.");
		}
	}

	public void cancelBy(User anUser) throws InvalidActionException {
		if (getVehicleOwner() == anUser || getRenter() == anUser) {
			switch (getState()) {
				case Initial:
					this.state = RentState.Canceled;
					List<User> toEmails = new ArrayList<>();
					toEmails.add(getVehicleOwner());
					toEmails.add(getRenter());
					EmailUtil.sendEmails(toEmails, "Renta Cancelada",
						"Le informamos que la renta del vehículo " + getVehicle().getBrand() + " " +
						getVehicle().getModel() + " para los días " + getWithdrawDate() + " al " + getReturnDate() +
						" ha sido cancelada por " + anUser.getName() + " " + anUser.getLastName() + ".\n" +
						"Esperamos sepa disculpar las molestias ocasionadas. El equipo de CARPND está para ayudarle.");
					break;
				case Canceled:
					break;
				default:
					throw new InvalidRentActionException("La renta actual no puede cancelada, por ya estar en curso.");
			}
		} else {
			throw new IllegalRentAccessException("Usted no está autorizado para cancelar esta renta.");
		}
	}

	public void confirmWithdrawBy(User anUser) throws InvalidActionException {
		if (!getState().userEmail.matches(anUser.getEmail()) &&
				getVehicleOwner() == anUser || getRenter() == anUser) {
			List<User> toEmails = new ArrayList<>();
			toEmails.add(getVehicleOwner());
			toEmails.add(getRenter());
			switch (getState()) {
				case Pending:
					this.state = RentState.WithdrawPreconfirmed;
					this.state.userEmail = anUser.getEmail();
					EmailUtil.sendEmails(toEmails, "Retiro de Vehículo Pre-Confirmado",
						"Le informamos que el retiro del vehículo " + getVehicle().getBrand() + " " + getVehicle().getModel() +
						" ya fue pre-confirmado por " + anUser.getName() + " " + anUser.getLastName() + "." +
						" Hace falta la confirmación de la otra parte para terminar de confirmar esta misma acción.\n");
					break;
				case WithdrawPreconfirmed:
					this.state = RentState.WithdrawConfirmed;
					EmailUtil.sendEmails(toEmails, "Retiro de Vehículo Confirmado",
						"Le informamos que el retiro del vehículo " + getVehicle().getBrand() + " " + getVehicle().getModel() +
						" ya fue confirmado por la contraparte: " + anUser.getName() + " " + anUser.getLastName() + ".");
					break;
				case WithdrawConfirmed:
					break;
				default:
					throw new InvalidRentActionException("No se puede confirmar el retiro del vehículo dado el estado " +
                            "actual de la renta");
			}
		} else {
			throw new IllegalRentAccessException("Usted no está autorizado para confirmar el retiro del vehículo.");
		}
	}

	public void confirmReturnBy(User anUser) throws InvalidActionException {
		if (!getState().userEmail.matches(anUser.getEmail()) &&
				getVehicleOwner() == anUser || getRenter() == anUser) {
			List<User> toEmails = new ArrayList<>();
			toEmails.add(getVehicleOwner());
			toEmails.add(getRenter());
			switch (getState()) {
				case WithdrawConfirmed:
					this.state = RentState.ReturnPreconfirmed;
					this.state.userEmail = anUser.getEmail();
					EmailUtil.sendEmails(toEmails, "Devolución de Vehículo Pre-Confirmada",
						"Le informamos que la devolución del vehículo " + getVehicle().getBrand() + " " + getVehicle().getModel() +
						" ya fue pre-confirmada por " + anUser.getName() + " " + anUser.getLastName() + "." +
						" Hace falta la confirmación de la otra parte para terminar de confirmar esta misma acción.\n");
					break;
				case ReturnPreconfirmed:
					this.state = RentState.ReturnConfirmed;
					EmailUtil.sendEmails(toEmails, "Devolución de Vehículo Confirmada",
						"Le informamos que la devolución del vehículo " + getVehicle().getBrand() + " " + getVehicle().getModel() +
						" ya fue confirmada por la contraparte: " + anUser.getName() + " " + anUser.getLastName() + ".\n" +
						" Agradecemos a ambos por haber confiado en nosotros para ponerlos en contacto y nos ponemos " +
						"a su disposición para más acciones futuras.\n Los saludamos muy atentamente \n El equipo de CARPND");
					break;
				case ReturnConfirmed:
					break;
				default:
					throw new InvalidRentActionException("No se puede confirmar la devolución del vehículo dado el " +
                            "estado actual de la renta.");
			}
		} else {
			throw new IllegalRentAccessException("Usted no está autorizado para confirmar la devolución del vehículo");
		}
	}
}
