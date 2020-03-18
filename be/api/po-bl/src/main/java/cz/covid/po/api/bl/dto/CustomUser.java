package cz.covid.po.api.bl.dto;

import cz.covid.po.api.domain.model.enumeration.AuthRole;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Getter
public class CustomUser extends User {
    /**
     * Guid fo person.
     */
    private UUID personUid;

    /**
     * Sequence id of user.
     */
    private Long userId;

    private CustomUser(String username, String password, AuthRole role, Long userId, boolean enable, boolean nonExpired, UUID personUid) {
        super(username, password, enable, true, nonExpired, true, Collections.singleton(new SimpleGrantedAuthority(role.name())));
        this.userId = userId;
        this.personUid = personUid;
    }

    public static CustomUser operator(String username, String password, boolean enabled, Long userId, AuthRole authRole) {
        return new CustomUser(username, password, authRole, userId, enabled, true, null);
    }

    public static CustomUser client(String phoneNumber, String code, UUID personUid, Long userId) {
        return new CustomUser(phoneNumber, code, AuthRole.CLIENT, userId, true, true, personUid);
    }
}
