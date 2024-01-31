
package org.sostrich.keycloak.pocs;

        import org.keycloak.Config.Scope;
        import org.keycloak.models.KeycloakSession;
        import org.keycloak.models.KeycloakSessionFactory;
        import org.keycloak.services.resource.RealmResourceProvider;
        import org.keycloak.services.resource.RealmResourceProviderFactory;

        import java.util.logging.Logger;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class HelloResourceProviderWorkingIn2205Factory implements RealmResourceProviderFactory {
    private static final Logger logger = Logger.getLogger(HelloResourceProviderWorkingIn2205Factory.class.getCanonicalName());

    public static final String ID = "hello";

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public RealmResourceProvider create(KeycloakSession session) {
        logger.info("creating resource");
        return new HelloResourceProviderWorkingIn2205(session);
    }

    @Override
    public void init(Scope config) {
        logger.info("initializing HelloResourceProviderFactory");
    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {
    }

    @Override
    public void close() {
    }

}
