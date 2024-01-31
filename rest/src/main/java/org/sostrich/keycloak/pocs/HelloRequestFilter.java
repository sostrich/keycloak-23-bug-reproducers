package org.sostrich.keycloak.pocs;


 import jakarta.ws.rs.container.ContainerRequestContext;
 import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.PreMatching;
 import jakarta.ws.rs.core.Response;
 import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@PreMatching
@Provider
public class HelloRequestFilter implements ContainerRequestFilter {


    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        requestContext.abortWith(Response

                .status(402)
                        .type("text/plain")
                .build());
    }
}
