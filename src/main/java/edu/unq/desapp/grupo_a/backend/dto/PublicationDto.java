package edu.unq.desapp.grupo_a.backend.dto;

public class PublicationDto {

    private Long id;
    private Long offerentId;
    private Long vehicleId;

    public void setOfferentId(Long id) {
        this.offerentId = id;
    }

    public void setVehicleId(Long id) {
        this.vehicleId = id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
