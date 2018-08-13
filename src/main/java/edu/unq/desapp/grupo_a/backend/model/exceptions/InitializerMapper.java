package edu.unq.desapp.grupo_a.backend.model.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InitializerMapper implements ExceptionMapper<InitializerException> {

    @Override
    public Response toResponse(InitializerException exception) {
        Response.Status status = Response.Status.NOT_ACCEPTABLE;
        return Response.status(status).entity(exception).build();
    }
}
