package org.sostrich.keycloak.pocs;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.keycloak.models.KeycloakSession;
import org.keycloak.services.resource.RealmResourceProvider;

public class MultipartFormDataResourceProvider implements RealmResourceProvider {

    /* support for containerrequestfilter/containerresponsefilter or dynamicfeature in keycloak extensions with 23 onward
     Hi,

We previously used both a [ContainerRequestFilter](https://jakarta.ee/specifications/platform/8/apidocs/javax/ws/rs/container/containerrequestfilter), and a [ContainerResponseFilter](https://jakarta.ee/specifications/platform/8/apidocs/javax/ws/rs/container/containerresponsefilter) for custom REST Endpoints in our keycloak extension.

I've been trying to update from 22.0.5 to 23.0.5, but I'm running into the issue that these no longer work.

I think it may have worked because of a little workaround we did (we annotated our RealmResource class with @Path(""), which worked for some reason when it was a public nested class of the RealmResourceProvider)  in version 22.0.5, This no longer works in 23.0.5

I requested, I an quickly create a reproducer repository of what I've tried and link to it here.*/

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
