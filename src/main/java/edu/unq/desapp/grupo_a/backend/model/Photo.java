package edu.unq.desapp.grupo_a.backend.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="photos")
public class Photo extends PersistenceEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vehicle vehicle;
	
	
	public Photo() {
		
	}
	
	@ManyToOne
	@JoinColumn
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}
