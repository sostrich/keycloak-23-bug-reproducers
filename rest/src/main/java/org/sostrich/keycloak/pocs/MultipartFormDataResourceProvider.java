package org.sostrich.keycloak.pocs;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.keycloak.models.KeycloakSession;
import org.keycloak.services.resource.RealmResourceProvider;

public class MultipartFormDataResourceProvider implements RealmResourceProvider {

    private KeycloakSession session;

    public MultipartFormDataResourceProvider(KeycloakSession session) {
        this.session = session;
    }

    @Override
    public Object getResource() {
        return this;
    }

    @Override
    public void close() {

    }

    @PUT
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("multipart")
    @Produces(MediaType.TEXT_PLAIN)
    public Response consumeMultipart(MultipartFormDataInput formFile)
    {
        return Response.ok().type(MediaType.MULTIPART_FORM_DATA).build();
    }

    @PUT
    @Path("non-multipart")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response nonMultipart() {
        return Response.status(200).type(MediaType.TEXT_PLAIN).build();
    }

}
