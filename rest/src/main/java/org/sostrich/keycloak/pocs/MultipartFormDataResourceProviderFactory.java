package org.sostrich.keycloak.pocs;

import org.keycloak.Config;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.services.resource.RealmResourceProvider;
import org.keycloak.services.resource.RealmResourceProviderFactory;

import java.util.logging.Logger;

public class MultipartFormDataResourceProviderFactory implements RealmResourceProviderFactory {

    public static final String ID = "multipart";
    private static final Logger logger = Logger.getLogger(HelloResourceProviderWorkingIn2205Factory.class.getCanonicalName());

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public RealmResourceProvider create(KeycloakSession session) {
        return new MultipartFormDataResourceProvider(session);
    }

    @Override
    public void init(Config.Scope config) {
    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {
    }

    @Override
    public void close() {
    }

}
