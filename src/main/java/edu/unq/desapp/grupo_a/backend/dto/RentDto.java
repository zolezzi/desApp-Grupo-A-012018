package edu.unq.desapp.grupo_a.backend.dto;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import edu.unq.desapp.grupo_a.backend.utils.JSONDateDeserialize;
import edu.unq.desapp.grupo_a.backend.utils.JSONSimpleDateSerialize;

public class RentDto {
	
	public Long id;
	
	public Long publicationId;
	
	public String model;
	
	public String brand;
	
	public String userName;
	
	public String state;
	
	public AddressDto addressDto;
	
	public Long renterId;
	
	public Long userId;
	
	public Double rentPrice;
	
	public String userRenterName;
	
	@JsonDeserialize(using = JSONDateDeserialize.class)
    @JsonSerialize(using = JSONSimpleDateSerialize.class)
    private Date startingDate;
	
	@JsonDeserialize(using = JSONDateDeserialize.class)
    @JsonSerialize(using = JSONSimpleDateSerialize.class)
    private Date endingDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPublicationId() {
		return publicationId;
	}

	public void setPublicationId(Long publicationId) {
		this.publicationId = publicationId;
	}

	public AddressDto getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}

	public Long getRenterId() {
		return renterId;
	}

	public void setRenterId(Long renterId) {
		this.renterId = renterId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getUserRenterName() {
		return userRenterName;
	}

	public void setUserRenterName(String userRenterName) {
		this.userRenterName = userRenterName;
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
	

}
