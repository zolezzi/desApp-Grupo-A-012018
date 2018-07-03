package edu.unq.desapp.grupo_a.backend.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import com.sun.istack.NotNull;

import edu.unq.desapp.grupo_a.backend.dto.VehicleDto;
import edu.unq.desapp.grupo_a.backend.model.exceptions.VehicleDataException;

@Entity
@Table(name = "vehicles")
@XmlAccessorType(XmlAccessType.FIELD)
public class Vehicle extends PersistenceEntity{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name = "vehicle_type", length = 20, nullable=false)
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @Column(name = "passenger_capability")
    private Integer passengerCapability;

    @Column(name = "vehicle_description")
    private String vehicleDescription;

    @Column(name = "model")
    private String model;

    @Column(name = "brand")
    private String brand;

    @Column(name = "patent")
    private String patent;

    @Column(name="photos")
    @ElementCollection
    private List<String> photos;

//    @OneToMany(targetEntity=Photo.class, mappedBy="vehicle", fetch=FetchType.EAGER)
//    @LazyCollection(LazyCollectionOption.FALSE)
//    private List<Photo> photos;
	
	@ManyToOne
	@XmlAttribute(name = "mappedUser")
	private User user;

	public Vehicle() {

    }

	public Vehicle (VehicleType vehicleType, int passengerCapability,
                    String vehicleDescription, List<String> photos) throws VehicleDataException {
        this.vehicleType = vehicleType;
        this.passengerCapability = passengerCapability;
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
		vehicleDto.setUserName(this.getUser().getName());
		vehicleDto.setUserId(this.getUser().getId());
		
		return vehicleDto;
	}

	public List<String> getPhotos() {
		return photos;
	}

	public void SetPhotos(List<String> photos) {
		this.photos = photos;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPatent() {
		return patent;
	}

	public void setPatent(String patent) {
		this.patent = patent;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public void setPassengerCapability(Integer passengerCapability) {
		this.passengerCapability = passengerCapability;
	}

	public void setVehicleDescription(String vehicleDescription) {
		this.vehicleDescription = vehicleDescription;
	}

	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}
}
