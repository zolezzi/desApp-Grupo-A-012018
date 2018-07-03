package edu.unq.desapp.grupo_a.backend.api;

import javax.ws.rs.*;

@Path("/creditAccounts")
@Consumes({"application/xml", "application/json"})
@Produces({"application/xml", "application/json"})
public interface CreditAccountResource {

    @GET
    @Path("/get-credit-account/{userId}")
    public double getCreditAmount(@PathParam("userId") long userId);

    @POST
    @Path("/add-credit/{userId}{amount}")
    public void addCredit(@PathParam("userId") long userId, @PathParam("amount") double amount);

    @POST
    @Path("/lose-credit/{userId}{amount}")
    public void loseCredit(@PathParam("userId") long userId, @PathParam("amount") double amount);
}
