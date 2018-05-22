package edu.unq.desapp.grupo_a.backend.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edu.unq.desapp.grupo_a.backend.dto.VehicleDto;
import edu.unq.desapp.grupo_a.backend.model.exceptions.VehicleDataException;
import edu.unq.desapp.grupo_a.backend.model.exceptions.WrongPublicationException;

import java.util.List;

@Entity
@Table(name = "vehicles")
public class Vehicle extends PersistenceEntity{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne(cascade=CascadeType.ALL)
	//@LazyCollection(LazyCollectionOption.FALSE)
    private VehicleType vehicleType;
    private int passengerCapability;
    private City city;
    private String vehicleDescription;
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
        this.city = city;
        this.vehicleDescription = vehicleDescription;
        this.photos = photos;
	}

    public static void check(int passengerCapability, String vehicleDescription)
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

    public City getCity() {
        return city;
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
//		vehicleDto.setVehicleDataDto(this.getVehicleData().toDto());
		
		return null;
	}

}
