package edu.unq.desapp.grupo_a.backend.model;

import com.sun.istack.NotNull;
import edu.unq.desapp.grupo_a.backend.dto.PublicationDto;
import edu.unq.desapp.grupo_a.backend.model.exceptions.WrongAddressException;
import edu.unq.desapp.grupo_a.backend.model.exceptions.WrongPublicationException;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "publications")
public class Publication extends PersistenceEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @NotNull
    @OneToOne
	private User offerent;

    @NotNull
    @OneToOne
	private Vehicle vehicle;

    @NotNull
    @OneToOne
	private Address withdrawAddress;

    @NotNull
	@OneToMany(targetEntity=Address.class, mappedBy="publication", fetch=FetchType.EAGER)
    @LazyCollection(LazyCollectionOption.FALSE)
	private List<Address> returnAddresses;

    @NotNull
    @OneToOne
    private LocalDate startingDate;

    @NotNull
    @OneToOne
    private LocalDate endingDate;

    @NotNull
	private Double rentPrice;

    public Publication(User offerent, Vehicle vehicle, Address withdrawAddress, List<Address> returnAddresses,
                       LocalDate startingDate, LocalDate endingDate, double rentPrice)
            throws WrongPublicationException, WrongAddressException {

        this.offerent = offerent;
        this.vehicle = vehicle;
        this.withdrawAddress = withdrawAddress;
        this.returnAddresses = returnAddresses;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.rentPrice = rentPrice;
    }

    public User getOfferent() {
        return offerent;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Address getWithdrawAddress() {
        return withdrawAddress;
    }

    public List<Address> getReturnAddresses() {
        return returnAddresses;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public Double getRentPrice() {
        return rentPrice;
    }

    public PublicationDto getDto() {

        PublicationDto publicationDto = new PublicationDto();
        publicationDto.setId(this.getId());
        publicationDto.setOfferentId(this.getOfferent().getId());
        publicationDto.setVehicleId(this.getVehicle().getId());

        return publicationDto;
    }
}
