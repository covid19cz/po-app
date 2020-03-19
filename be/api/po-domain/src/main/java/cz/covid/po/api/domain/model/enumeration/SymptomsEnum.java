package cz.covid.po.api.domain.model.enumeration;

import java.util.EnumSet;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;

public enum SymptomsEnum {

    NONE, MORE, ONE_OR_TWO, THREE_OR_FOUR;

    public static Optional<SymptomsEnum> findByName(String role) {
        return EnumSet.allOf(SymptomsEnum.class).stream()
                .filter(s -> StringUtils.equalsIgnoreCase(s.name(), role))
                .findFirst();
    }
}
