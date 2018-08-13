package edu.unq.desapp.grupo_a.backend.model.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidActionMapper implements ExceptionMapper<InvalidActionException> {

    @Override
    public Response toResponse(InvalidActionException exception) {
        Response.Status status;
        if (exception.getCause() instanceof IllegalRentAccessException) {
            status = Response.Status.UNAUTHORIZED;
        } else {
            status = Response.Status.METHOD_NOT_ALLOWED;
        }
        return Response.status(status).entity(exception).build();
    }
}
