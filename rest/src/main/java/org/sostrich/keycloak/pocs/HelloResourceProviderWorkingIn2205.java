package org.sostrich.keycloak.pocs;

import jakarta.ws.rs.Path;
import org.keycloak.models.KeycloakSession;
import org.keycloak.services.resource.RealmResourceProvider;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;

public class HelloResourceProviderWorkingIn2205 implements RealmResourceProvider {

    private KeycloakSession session;

    public HelloResourceProviderWorkingIn2205(KeycloakSession session) {
        this.session = session;
    }

    @Override
    public Object getResource() {
        return new HelloResourceWorkingIn2205(session);
    }

   //@Path("")
    public static class HelloResourceWorkingIn2205 {
        private KeycloakSession session;

        public HelloResourceWorkingIn2205(KeycloakSession session) {
            this.session = session;
        }

        @GET
        @Path("hello")
        @Produces("text/plain; charset=utf-8")
        public String get() {
            String name = session.getContext().getRealm().getDisplayName();
            if (name == null) {
                name = session.getContext().getRealm().getName();
            }
            return "Hello " + name;
        }

    }

    @Override
    public void close() {
    }

}
