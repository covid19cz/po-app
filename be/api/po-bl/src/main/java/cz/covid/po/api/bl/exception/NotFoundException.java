package cz.covid.po.api.bl.exception;

public class NotFoundException extends AbstractException {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param propertyKey   name of property on searched entity by eg. <code>name</code>
     * @param propertyValue price of property on searched entity eg. <code>Vladimir Rehor</code>
     * @param clazz         class of searched entity
     */
    public static String createSystemMessage(final String propertyKey, final Object propertyValue, final Class clazz) {
        return clazz.getSimpleName() + " with " + propertyKey + " = " + (propertyValue == null ? null : propertyValue.toString()) + " not found";
    }
}
