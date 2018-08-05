package edu.unq.desapp.grupo_a.backend.api;

import javax.ws.rs.*;

import edu.unq.desapp.grupo_a.backend.dto.UserDto;

@Path("/credit-amount")
@Consumes({"application/xml", "application/json"})
@Produces({"application/xml", "application/json"})
public interface CreditAccountResource {

    @GET
    @Path("/get-credit-account/{userId}")
    public Double getCreditAmount(@PathParam("userId") Long userId);

    @POST
    @Path("/add-credit/{userId}")
    public UserDto addCredit(@PathParam("userId") Long userId, Double amount);

    @POST
    @Path("/lose-credit/{userId}")
    public UserDto loseCredit(@PathParam("userId") Long userId, Double amount);
}
