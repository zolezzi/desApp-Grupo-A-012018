package edu.unq.desapp.grupo_a.backend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.sun.istack.NotNull;

import edu.unq.desapp.grupo_a.backend.dto.VehicleDto;
import edu.unq.desapp.grupo_a.backend.model.exceptions.VehicleDataException;

import java.util.List;

@Entity
@Table(name = "vehicles")
public class Vehicle extends PersistenceEntity{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name = "vehicle_type", length = 20, nullable=false)
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    private Integer passengerCapability;

    private String vehicleDescription;

    @OneToMany(targetEntity=Photo.class, mappedBy="vehicle", fetch=FetchType.EAGER)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Photo> photos;
	
	@ManyToOne
	private User user;
	
	public Vehicle (VehicleType vehicleType, int passengerCapability, City city,
                    String vehicleDescription, List<Photo> photos) throws VehicleDataException {
        try {
            VehicleType.check(vehicleType);
            City.check(city);
            Photo.check(photos);
            check(passengerCapability, vehicleDescription);
        } catch(VehicleDataException e) {
            throw e;
        }
        this.vehicleType = vehicleType;
        this.passengerCapability = passengerCapability;
        //this.city = city;
        this.vehicleDescription = vehicleDescription;
        this.photos = photos;
	}

    private static void check(int passengerCapability, String vehicleDescription)
            throws VehicleDataException {
        if (passengerCapability <= 0 ||
                vehicleDescription == null || vehicleDescription.trim().isEmpty()) {
            throw new VehicleDataException();
        }
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getPassengerCapability() {
        return passengerCapability;
    }

    public String getVehicleDescription() {
        return vehicleDescription;
    }
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public VehicleDto toDto() {
		
		VehicleDto vehicleDto = new VehicleDto();
		vehicleDto.setId(this.getId());
		vehicleDto.setUserDto(this.getUser().toDto());
		
		return null;
	}

	public List<Photo> getPhotos() {
		return photos;
	}
}
