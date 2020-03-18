package cz.covid.po.api.domain.model.enumeration;

import java.util.EnumSet;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum AuthRole {

    ADMIN, CLIENT, ANONYM;

    public static Optional<AuthRole> findByName(String role) {
        return EnumSet.allOf(AuthRole.class).stream()
                .filter(authRole -> StringUtils.equalsIgnoreCase(authRole.name(), role))
                .findFirst();
    }

    public GrantedAuthority toGrantedAuthority() {
        return new SimpleGrantedAuthority(name());
    }

}
