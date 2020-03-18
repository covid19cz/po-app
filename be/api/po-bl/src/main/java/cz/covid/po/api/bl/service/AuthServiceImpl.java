package cz.covid.po.api.bl.service;

import cz.covid.po.api.bl.constant.OauthConstants;
import cz.covid.po.api.domain.model.enumeration.AuthRole;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Stream;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;

@Service
@Profile("!test")
public class AuthServiceImpl implements AuthService {

    //TODO(pdvorak, 04.03.2019): these methods maybe should returns optional
    @Override
    public Long getLoggedUserId() {
        return getOauthDetails().map(details -> {
            Map decodedDetails = (Map) details.getDecodedDetails();
            Object object = decodedDetails.get(OauthConstants.LOG_USER_ID);
            if (object != null) {
                return Long.valueOf(String.valueOf(object));
            } else {
                return null;
            }
        }).orElse(null);
    }

    @Override
    public UUID getPersonUid() {
        return getOauthDetails().map(details -> {
            Map decodedDetails = (Map) details.getDecodedDetails();
            if (decodedDetails.get(OauthConstants.LOG_PERSON_UID) instanceof String) {
                final String personUid = (String) decodedDetails.get(OauthConstants.LOG_PERSON_UID);
                return UUID.fromString(personUid);
            } else {
                return (UUID) decodedDetails.get(OauthConstants.LOG_PERSON_UID);
            }
        }).orElse(null);
    }

    @Override
    public AuthRole getLoggedUserRole() {
        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .map(Authentication::getAuthorities)
                .map(Collection::stream)
                .flatMap(Stream::findFirst)
                .map(this::toAuthRole)
                .orElse(AuthRole.ANONYM);
    }

    @Override
    public boolean isAnonymous() {
        return getLoggedUserRole() == AuthRole.ANONYM;
    }

    @Override
    public AuthRole toAuthRole(GrantedAuthority grantedAuthority) {
        return AuthRole.findByName(grantedAuthority.getAuthority()).orElse(null);
    }

    @Override
    public boolean isAdmin() {
        return getLoggedUserRole() == AuthRole.ADMIN;
    }

    @Override
    public boolean hasRole(Set<AuthRole> roles) {
        return roles.contains(getLoggedUserRole());
    }

    private Optional<OAuth2AuthenticationDetails> getOauthDetails() {
        Object details = Optional.ofNullable(SecurityContextHolder.getContext()).map(SecurityContext::getAuthentication).map(Authentication::getDetails).orElse(null);
        if (details instanceof OAuth2AuthenticationDetails) {
            return Optional.of((OAuth2AuthenticationDetails) details);
        }
        return Optional.empty();
    }
}
