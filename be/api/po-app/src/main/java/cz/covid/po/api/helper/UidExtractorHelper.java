package cz.covid.po.api.helper;

import cz.covid.po.api.bl.service.AuthService;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class UidExtractorHelper {

    private static final String PERSONS = "persons";

    public Optional<String> getPersonUid(String requestURI) {
        return fromUri(PERSONS, requestURI);
    }

    private Optional<String> fromUri(String path, String requestURI) {
        Pattern pattern = Pattern.compile(path + "/(.{8}-.{4}-.{4}-.{4}-.{12})/?");
        Matcher matcher = pattern.matcher(requestURI);
        if (matcher.find()) {
            return Optional.of(matcher.group(1));
        } else {
            return Optional.empty();
        }
    }
}
