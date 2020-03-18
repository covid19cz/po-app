package cz.covid.po.api.bl.util;

import java.util.function.Consumer;
import java.util.function.Supplier;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PatchUtil {

    /**
     * Check if value is not null and call the consumer.
     *
     * @param value    value
     * @param function consumer to call if value is not null
     * @param <T>      type of value
     */
    public <T> void callIfNotNull(T value, Consumer<T> function) {
        if (value != null) {
            function.accept(value);
        }
    }

    /**
     * Set {@code value} to field, if field is {@code null}.
     *
     * @param value  value to set, if null do nothing
     * @param getter getter function of field, for check to null
     * @param setter setter function of field
     * @param <T>    type of value
     */
    public <T> void setIfNull(T value, Supplier<T> getter, Consumer<T> setter) {
        if (value == null) {
            return;
        }
        if (getter.get() == null) {
            setter.accept(value);
        }
    }
}
