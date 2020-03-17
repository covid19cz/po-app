package cz.covid.po.api.integration.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.util.List;

/**
 * Util class converting json to object and backwards
 */
public class JsonMapperUtil {

    private final static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    /**
     * Convert object to json string or null.
     *
     * @param response response
     * @param <T>      object type
     */
    public static <T> String toJsonQuietly(T response) {
        try {
            return toJson(response);
        } catch (JsonProcessingException e) {
            //log.error("Cannot convert to JSON {}.\nException: {}", response, e);
            return null;
        }
    }

    /**
     * Convert json to object.
     *
     * @param json input json to convert
     * @param <T>  type of output object
     *
     * @return converted object
     */
    public static <T> T toObject(String json, Class<T> clazz) throws IOException {
        return mapper.readValue(json, clazz);
    }

    /**
     * Convert object to string JSON
     *
     * @param object object to convert
     * @param <T>    type of object
     *
     * @return converted string json
     */
    public static <T> String toJson(T object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

    /**
     * Convert json to list of object.
     *
     * @param json input json to convert
     * @param <T>  type of output object
     *
     * @return converted object
     */
    public <T> List<T> toListOfObject(String json, Class<T> clazz) throws IOException {
        JavaType type = mapper.getTypeFactory().constructParametricType(List.class, clazz);
        return mapper.readValue(json, type);
    }
}
