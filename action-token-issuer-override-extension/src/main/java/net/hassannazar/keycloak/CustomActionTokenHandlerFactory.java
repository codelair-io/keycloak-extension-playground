package io.codelair.keycloak;

import org.keycloak.authentication.actiontoken.ActionTokenHandlerFactory;

/**
 * Purpose:
 *
 * @author Hassan Nazar
 * @author www.hassannazar.net
 */
public class CustomActionTokenHandlerFactory implements ActionTokenHandlerFactory {

    @Override
    public String getId() {
        return null;
    }

}
