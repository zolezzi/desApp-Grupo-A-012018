package edu.unq.desapp.grupo_a.backend.bootLoad;

import edu.unq.desapp.grupo_a.backend.api.*;
import edu.unq.desapp.grupo_a.backend.dto.PublicationDto;
import edu.unq.desapp.grupo_a.backend.dto.UserDto;
import edu.unq.desapp.grupo_a.backend.dto.VehicleDto;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DataLoader {

    private UserResource userResource;
    private VehicleResource vehicleResource;
    private PublicationResource publicationResource;
    private RentResource rentResource;

    public void initialize() {

        UserDto juanPerezDto = new UserDto();
        juanPerezDto.setName("Juan");
        juanPerezDto.setLastName("Perez");
        juanPerezDto.setCreditAmout(1000.0);
        juanPerezDto.setEmail("juanPerez@gmail.com");
        juanPerezDto.setCuil("20-12312312-7");
        juanPerezDto.setId(1L);
        UserDto juanPerez = userResource.createUser(juanPerezDto);

        VehicleDto peugeot505 = new VehicleDto();
        peugeot505.setUserId(juanPerez.getId());
        peugeot505.setUserName(juanPerez.getName() + " " + juanPerez.getLastName());
        peugeot505.setBrand("Peugeot");
        peugeot505.setModel("505");
        peugeot505.setPassengerCapability(5);
        peugeot505.setVehicleType("Car");
        peugeot505.setVehicleDescription("Peugeot 505 en buen estado, con amplio baúl. Perfecto para ir de camping.");
        peugeot505.setPatent("PEU-505");
        vehicleResource.addVehicle(peugeot505);

        PublicationDto publicationPeugeot505 = new PublicationDto();
        publicationPeugeot505.setUserOfferentId(juanPerez.getId());
        publicationPeugeot505.setUserOfferentName(juanPerez.getName() + " " + juanPerez.getLastName());
        publicationPeugeot505.setVehicleId(peugeot505.getId());
        publicationPeugeot505.setBrand(peugeot505.getBrand());
        publicationPeugeot505.setModel(peugeot505.getModel());
        publicationPeugeot505.setRentPrice(1500.0);
        Date startingDate = new Date();
        publicationPeugeot505.setStartingDate(startingDate);
        Date endingDate = new Date();
        publicationPeugeot505.setEndingDate(endingDate);
        publicationPeugeot505.setDescription(peugeot505.getVehicleDescription());
        publicationResource.setPublication(publicationPeugeot505);

        VehicleDto ferrariTestarrosa = new VehicleDto();
        ferrariTestarrosa.setUserId(juanPerez.getId());
        ferrariTestarrosa.setUserName(juanPerez.getName() + " " + juanPerez.getLastName());
        ferrariTestarrosa.setBrand("Ferrari");
        ferrariTestarrosa.setModel("Testarrosa");
        ferrariTestarrosa.setPassengerCapability(2);
        ferrariTestarrosa.setVehicleType("Car");
        ferrariTestarrosa.setVehicleDescription("Nunca taxi");
        ferrariTestarrosa.setPatent("FER-735");
        vehicleResource.addVehicle(ferrariTestarrosa);

        PublicationDto publicationFerrariTestarrosa = new PublicationDto();
        publicationFerrariTestarrosa.setUserOfferentId(juanPerez.getId());
        publicationFerrariTestarrosa.setUserOfferentName(juanPerez.getName() + " " + juanPerez.getLastName());
        publicationFerrariTestarrosa.setVehicleId(ferrariTestarrosa.getId());
        publicationFerrariTestarrosa.setBrand(ferrariTestarrosa.getBrand());
        publicationFerrariTestarrosa.setModel(ferrariTestarrosa.getModel());
        publicationFerrariTestarrosa.setRentPrice(4500.0);
        startingDate = new Date();
        publicationFerrariTestarrosa.setStartingDate(startingDate);
        endingDate = new Date();
        publicationFerrariTestarrosa.setEndingDate(endingDate);
        publicationFerrariTestarrosa.setDescription(ferrariTestarrosa.getVehicleDescription());
        publicationResource.setPublication(publicationFerrariTestarrosa);
    }

    public void setUserResource(UserResource userResource) {
        this.userResource = userResource;
    }

    public void setVehicleResource(VehicleResource vehicleResource) {
        this.vehicleResource = vehicleResource;
    }

    public void setPublicationResource(PublicationResource publicationResource) {
        this.publicationResource = publicationResource;
    }

    public void setRentResource(RentResource rentResource) {
        this.rentResource = rentResource;
    }
}
