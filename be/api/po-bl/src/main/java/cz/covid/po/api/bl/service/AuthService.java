package cz.covid.po.api.bl.service;

import cz.covid.po.api.domain.model.enumeration.AuthRole;
import java.util.Set;
import java.util.UUID;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public interface AuthService {
    /**
     * Return sequence id of logged {@link User}.
     *
     * @return id of user
     */
    Long getLoggedUserId();

    /**
     * Get an client uuid from JWT token.
     *
     * @return uid of person
     */
    UUID getPersonUid();

    /**
     * Return {@link AuthRole} of logged {@link User}.
     *
     * @return role
     */
    AuthRole getLoggedUserRole();

    /**
     * Check if user is authorized.
     *
     * @return TRUE - if user is not logged in
     */
    boolean isAnonymous();

    /**
     * Convert authentication role in String to {@link AuthRole}.
     *
     * @param grantedAuthority authentication role in String
     *
     * @return authentication role in {@link AuthRole}
     */
    AuthRole toAuthRole(GrantedAuthority grantedAuthority);

    /**
     * Check if user is admin.
     *
     * @return TRUE - if user has role ADMIN
     */
    boolean isAdmin();

    /**
     * Check if user has one of roles in `roles`
     *
     * @param roles set of {@link AuthRole}s
     *
     * @return TRUE - if user has one of `roles`
     */
    boolean hasRole(Set<AuthRole> roles);
}
