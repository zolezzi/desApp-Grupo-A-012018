package edu.unq.desapp.grupo_a.backend.dto;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import edu.unq.desapp.grupo_a.backend.utils.JSONDateDeserialize;
import edu.unq.desapp.grupo_a.backend.utils.JSONSimpleDateSerialize;

public class PublicationDto {

    private Long id;
    
    private Long UserOfferentId;
    
    private Long vehicleId;
    
    private String userOfferentName;   
    
	@JsonDeserialize(using = JSONDateDeserialize.class)
    @JsonSerialize(using = JSONSimpleDateSerialize.class)
    private Date startingDate;
	
	@JsonDeserialize(using = JSONDateDeserialize.class)
    @JsonSerialize(using = JSONSimpleDateSerialize.class)
    private Date endingDate;

    private Double rentPrice;

    private AddressDto withdrawAddress;

    private AddressDto returnAddress;
    
    private List<String> photos;
    
    private String description;
    
    private String model;
    
    private String brand;
    

    
    public PublicationDto() {
    	
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getUserOfferentId() {
		return UserOfferentId;
	}

	public void setUserOfferentId(Long userOfferentId) {
		UserOfferentId = userOfferentId;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getUserOfferentName() {
		return userOfferentName;
	}

	public void setUserOfferentName(String userOfferentName) {
		this.userOfferentName = userOfferentName;
	}

	public Double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public AddressDto getWithdrawAddress() {
		return withdrawAddress;
	}

	public void setWithdrawAddress(AddressDto withdrawAddress) {
		this.withdrawAddress = withdrawAddress;
	}

	public AddressDto getReturnAddress() {
		return returnAddress;
	}

	public void setReturnAddress(AddressDto returnAddress) {
		this.returnAddress = returnAddress;
	}

	public List<String> getPhotos() {
		return photos;
	}

	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
    

}
    
