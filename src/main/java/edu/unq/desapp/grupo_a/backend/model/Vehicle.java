package edu.unq.desapp.grupo_a.backend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edu.unq.desapp.grupo_a.backend.model.exceptions.VehicleDataException;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "vehicles")
public class Vehicle extends PersistenceEntity{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne(cascade=CascadeType.ALL)
	//@LazyCollection(LazyCollectionOption.FALSE)
	private VehicleData vehicleData;
	
	@ManyToOne
	private User user;
	
	public Vehicle (VehicleData vehicleData) throws VehicleDataException {
        try {
            VehicleData.check(vehicleData);
        } catch(VehicleDataException e) {
            throw e;
        }
		this.vehicleData = vehicleData;

	}
	
	public VehicleData getVehicleData() {
		return this.vehicleData;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
