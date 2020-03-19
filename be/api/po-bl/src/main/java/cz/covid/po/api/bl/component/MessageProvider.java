package cz.covid.po.api.bl.component;

import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class MessageProvider {

    private static final Locale LOCALE_CZECH = new Locale("cs", "CZ");
    public static final Locale LOCALE_DEFAULT = LOCALE_CZECH;

    private final MessageSource messageSource;

    public String getMessage(final String code, final Object... args) {
        if (code == null) {
            return null;
        }
        return messageSource.getMessage(code, args, LOCALE_DEFAULT);
    }

}
