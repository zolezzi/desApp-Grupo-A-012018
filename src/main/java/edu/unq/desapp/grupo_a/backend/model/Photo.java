package edu.unq.desapp.grupo_a.backend.model;

import java.util.List;

import edu.unq.desapp.grupo_a.backend.model.exceptions.VehicleDataException;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="photos")
public class Photo extends PersistenceEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void check(List<Photo> photos) throws VehicleDataException {
		if (photos == null) {
			throw new VehicleDataException();
		} else {
			for (Photo photo : photos) {
				check(photo);
			}
		}
	}

	public static void check(Photo photo) throws VehicleDataException {
		if (photo == null) {
			throw new VehicleDataException();
		}
	}
}
