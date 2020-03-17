package cz.covid.po.api.integration.common.util;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public final class UriParamUtil {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final JavaType type = mapper.getTypeFactory().constructMapType(Map.class, String.class, String.class);

    public static <T> MultiValueMap<String, String> toParamMap(T object) {
        Map<String, String> map = mapper.convertValue(object, type);
        MultiValueMap<String, String> map2 = new LinkedMultiValueMap<>();
        map2.setAll(map);
        return map2;
    }

}
