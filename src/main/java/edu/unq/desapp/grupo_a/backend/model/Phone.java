package edu.unq.desapp.grupo_a.backend.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.unq.desapp.grupo_a.backend.model.exceptions.VehicleDataException;

@Entity
@Table(name = "phone")
public class Phone extends PersistenceEntity{

	@ManyToOne
	@JoinColumn
	private VehicleData vehicleData;
	
	public static void check(Phone phone) throws VehicleDataException {
		if (phone == null) {
			throw new VehicleDataException();
		}
	}
}
