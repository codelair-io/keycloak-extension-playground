package io.codelair.keycloak;

import org.keycloak.authentication.actiontoken.DefaultActionToken;
import org.keycloak.common.util.Time;
import org.keycloak.models.RealmModel;
import org.keycloak.models.KeycloakSession;

import javax.ws.rs.core.UriInfo;

/**
 * Purpose:
 *
 * @author Hassan Nazar
 * @author www.hassannazar.net
 */
public class CustomActionToken extends DefaultActionToken {

    public static final String TOKEN_TYPE = "custom-action-token-w-issuer-overwrite";

    public CustomActionToken(String userId, int absoluteExpirationInSecs, String compoundAuthenticationSessionId) {
        super(userId, TOKEN_TYPE, absoluteExpirationInSecs, null, compoundAuthenticationSessionId);
    }

    private CustomActionToken() {
        // Required to deserialize from JWT
        super();
    }

    @Override
    public String serialize(KeycloakSession session, RealmModel realm, UriInfo uri) {
        this.issuedAt(Time.currentTime()).id(this.getActionVerificationNonce().toString()).issuer("SEB").audience(new String[]{"SEB"});
        return session.tokens().encode(this);
    }
}
