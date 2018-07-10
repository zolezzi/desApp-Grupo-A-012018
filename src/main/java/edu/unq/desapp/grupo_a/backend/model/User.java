package edu.unq.desapp.grupo_a.backend.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import edu.unq.desapp.grupo_a.backend.dto.UserDto;
import edu.unq.desapp.grupo_a.backend.model.exceptions.UserInitException;

@Entity
@Table(name = "users")
@XmlRootElement(name = "vehicles")
@XmlAccessorType(XmlAccessType.FIELD)
public class User extends PersistenceEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "cuil", nullable = false)
	private String cuil;
	
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	
	@Column(name = "last_name", length = 100, nullable = false)
	private String lastName;

	@Column(name = "user_email", length = 50)
	private String email;
	
	@Column(name = "user_reputation", nullable = false)
	private Integer reputation;
	
	@Column(name = "google_id")
	public String idGoogle;
	
	@Column(name = "facebook_id")
	public String idFacebook;
	
	@XmlElement(name = "vehicle")
	@OneToMany(targetEntity=Vehicle.class, cascade = CascadeType.ALL, mappedBy="user", fetch=FetchType.LAZY)
	private List<Vehicle> vehicles;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private CreditAccount creditAccount;
	
	public User() {
		
	}
	
	public User(String cuil, String name, Address address, String email) throws UserInitException{
		this.cuil = cuil;
		this.name = name;
		//this.address = address;
		this.email = email;
		this.reputation = 0;
		this.vehicles = new ArrayList<>();
		this.creditAccount = new CreditAccount();
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getReputation() {
		return reputation;
	}

	public void setReputation(Integer reputation) {
		this.reputation = reputation;
	}
	
	public CreditAccount getCreditAccount() {
		return creditAccount;
	}

	public void setCreditAccount(CreditAccount creditAccount) {
		this.creditAccount = creditAccount;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	
    public void addVehicle(Vehicle vehicle) {
    	if (vehicle != null) {
    		vehicle.setUser(this);
    	}
		this.vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        this.vehicles.remove(vehicle);
    }

    public void addCredit(Double amount) {
        this.creditAccount.addAmount(amount);
    }

    public void loseCredit(Double amount) {
        this.creditAccount.loseAmount(amount);
    }

    public String getIdGoogle() {
		return idGoogle;
	}

	public void setIdGoogle(String idGoogle) {
		this.idGoogle = idGoogle;
	}

	public String getIdFacebook() {
		return idFacebook;
	}

	public void setIdFacebook(String idFacebook) {
		this.idFacebook = idFacebook;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public UserDto toDto() {
    	
    	UserDto userDto = new UserDto();
    	
    	userDto.setId(this.getId());
    	userDto.setCuil(this.getCuil());
    	userDto.setName(this.getName());
    	userDto.setEmail(this.getEmail());
    	userDto.setReputation(this.getReputation());
    	userDto.setLastName(getLastName());
    	if (this.getCreditAccount() != null) {
    		userDto.setCreditAmout(this.getCreditAccount().getCurrentAmount());
    	}
//    	if (this.getAddress() != null) {
//    		userDto.setAddress(this.getAddress().toDto());
//    	}
    	
    	if(this.getVehicles() != null) {
        	userDto.setVehicles(this.getVehicles().stream().map(vehicle -> vehicle.toDto()).collect(Collectors.toList()));
    	}
    	
    	return userDto;
    }
}
