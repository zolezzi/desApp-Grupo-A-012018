package edu.unq.desapp.grupo_a.backend.model;

import edu.unq.desapp.grupo_a.backend.dto.AddressDto;
import edu.unq.desapp.grupo_a.backend.model.exceptions.UserInitException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "street_name", nullable = false)
	private String streetName;
	
	@Column(name = "comments")
	private String comments;
	
	@Column(name = "coord_lat")
	private Double coordLat;
	
	@Column(name = "coord_long")
	private Double coordLong;
	
	@Column(name = "street_number")
	private String streetNumber;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "district_name")
	private String districtName;
	
	@Column(name = "zip_code", nullable = false)
	private String zipCode;

	@Column(name = "floor")
	private String floor;
	
	@Column(name = "between_street1")
	private String betweenStreet1;
	
	@Column(name = "between_street2")
	private String betweenStreet2;


	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getStreetName() {
		return streetName;
	}
	
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	public String getComments() {
		return comments;
	}
	
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public Double getCoordLat() {
		return coordLat;
	}
	
	public void setCoordLat(Double coordLat) {
		this.coordLat = coordLat;
	}
	
	public Double getCoordLong() {
		return coordLong;
	}
	
	public void setCoordLong(Double coordLong) {
		this.coordLong = coordLong;
	}
	
	public String getStreetNumber() {
		return streetNumber;
	}
	
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getDistrictName() {
		return districtName;
	}
	
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getFloor() {
		return floor;
	}
	
	public void setFloor(String floor) {
		this.floor = floor;
	}
	
	public String getBetweenStreet1() {
		return betweenStreet1;
	}
	
	public void setBetweenStreet1(String betweenStreet1) {
		this.betweenStreet1 = betweenStreet1;
	}
	
	public String getBetweenStreet2() {
		return betweenStreet2;
	}
	
	public void setBetweenStreet2(String betweenStreet2) {
		this.betweenStreet2 = betweenStreet2;
	}

	public static void check(Address address) throws UserInitException {
		if (address == null) {
			throw new UserInitException();
		}
	}
	
	public AddressDto toDto() {
		
		AddressDto addressDto = new AddressDto();
		
		addressDto.setId(this.getId());
		addressDto.setStreetName(this.getStreetName());
		addressDto.setComments(this.getComments());
		addressDto.setCoordLat(this.getCoordLat());
		addressDto.setCoordLong(this.getCoordLong());
		addressDto.setStreetNumber(this.getStreetNumber());
		addressDto.setDepartment(this.getDepartment());
		addressDto.setDistrictName(this.getDistrictName());
		addressDto.setZipCode(this.getZipCode());
		addressDto.setFloor(this.getFloor());
		addressDto.setBetweenStreet1(this.getBetweenStreet1());
		addressDto.setBetweenStreet2(this.getBetweenStreet2());
		
		return addressDto;
	}

}
