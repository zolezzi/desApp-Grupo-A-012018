package edu.unq.desapp.grupo_a.backend.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import edu.unq.desapp.grupo_a.backend.dto.PublicationDto;
import edu.unq.desapp.grupo_a.backend.model.exceptions.WrongAddressException;
import edu.unq.desapp.grupo_a.backend.model.exceptions.WrongPublicationException;
import edu.unq.desapp.grupo_a.backend.utils.JSONDateDeserialize;
import edu.unq.desapp.grupo_a.backend.utils.JSONDateSerialize;

@Entity
@Table(name = "publications")
public class Publication extends PersistenceEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @OneToOne
	private User offerent;

    @OneToOne
	private Vehicle vehicle;

    @OneToOne(cascade=CascadeType.ALL)
	private Address withdrawAddress;

    @OneToOne(cascade=CascadeType.ALL)
	private Address returnAddress;

    @Temporal(TemporalType.DATE)
	@JsonDeserialize(using = JSONDateDeserialize.class)
	@JsonSerialize(using = JSONDateSerialize.class)
    private Date startingDate;

    @Temporal(TemporalType.DATE)
	@JsonDeserialize(using = JSONDateDeserialize.class)
	@JsonSerialize(using = JSONDateSerialize.class)
    private Date endingDate;

    @Column(name = "rent_price")
	private Double rentPrice;
   
    @Column(name="photos")
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> photos;
    
    public Publication() {

	}

	@Column(name="description")
    private String description;

    public Publication(User offerent, Vehicle vehicle, Address withdrawAddress, Address returnAddress,
    		Date startingDate2, Date endingDate2, double rentPrice)
            throws WrongPublicationException, WrongAddressException {

        this.offerent = offerent;
        this.vehicle = vehicle;
        this.withdrawAddress = withdrawAddress;
        this.returnAddress = returnAddress;
        this.startingDate = startingDate2;
        this.endingDate = endingDate2;
        this.rentPrice = rentPrice;
    }

    public User getOfferent() {
		return offerent;
	}

	public void setOfferent(User offerent) {
		this.offerent = offerent;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Address getWithdrawAddress() {
		return withdrawAddress;
	}

	public void setWithdrawAddress(Address withdrawAddress) {
		this.withdrawAddress = withdrawAddress;
	}

	public Address getReturnAddress() {
		return returnAddress;
	}

	public void setReturnAddress(Address returnAddress) {
		this.returnAddress = returnAddress;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public Date getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}

	public Double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public List<String> getPhotos() {
		return photos;
	}

	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PublicationDto toDto() {

        PublicationDto publicationDto = new PublicationDto();
        publicationDto.setId(getId());
        publicationDto.setUserOfferentId(getOfferent().getId());
        publicationDto.setVehicleId(getVehicle().getId());
        publicationDto.setBrand(getVehicle().getBrand());
        publicationDto.setModel(getVehicle().getModel());
        publicationDto.setPhotos(getPhotos());
        publicationDto.setDescription(getDescription());
        publicationDto.setRentPrice(getRentPrice());
        publicationDto.setUserOfferentName(getOfferent().getName());
        publicationDto.setStartingDate(getStartingDate());
        publicationDto.setEndingDate(getEndingDate());
        publicationDto.setReturnAddress(getReturnAddress().toDto());
        publicationDto.setWithdrawAddress(getWithdrawAddress().toDto());
        
        return publicationDto;
    }
}
