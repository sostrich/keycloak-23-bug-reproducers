/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
