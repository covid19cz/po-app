package cz.covid.po.api.integration.captcha.service;

import cz.covid.po.api.integration.captcha.dto.CaptchaResponse;
import cz.covid.po.api.integration.common.exception.IntegrationException;
import cz.covid.po.api.integration.common.util.JsonMapperUtil;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URISyntaxException;

import static cz.covid.po.api.integration.common.enumeration.IntegrationSystem.GOOGLE_CAPTCHA;

@Service
public class CaptchaValidatorImpl implements CaptchaValidator {

    @Value("${app.integration.captcha.secret}")
    private String secret;
    @Value("${app.integration.captcha.url}")
    private String baseUrl;

    private WebClient webClient;

    @PostConstruct
    public void init() {
        webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }


    @Override
    public boolean verifyCaptcha(final String userToken, final String remoteIp) {
        try {
            final URIBuilder uri = new URIBuilder(baseUrl).addParameter("secret", secret).addParameter("response", userToken);
            if (remoteIp != null) {
                uri.addParameter("user_ip", remoteIp);
            }

            ClientResponse resp = webClient.post()
                    .uri(uri.build())
                    .exchange()
                    .block();

            if (resp != null && resp.statusCode().is2xxSuccessful()) {
                CaptchaResponse captchaResp = mapResponseToCaptchaResponse(resp);

                if (captchaResp.getErrorCodes() == null || captchaResp.getErrorCodes().isEmpty()) {
                    return captchaResp.isSuccess();
                }
                return false;
            } else {
                throw new IntegrationException("Captcha verification failed ", GOOGLE_CAPTCHA);
            }
        } catch (URISyntaxException e) {
            throw new IntegrationException("Error while building URI" + e.getMessage(), GOOGLE_CAPTCHA);
        }
    }

    private CaptchaResponse mapResponseToCaptchaResponse(final ClientResponse resp) {
        String stringResponse = resp.bodyToMono(String.class).block();
        try {
            return JsonMapperUtil.toObject(stringResponse, CaptchaResponse.class);
        } catch (IOException e) {
            throw new IntegrationException("Error parsing response: " + stringResponse, e, GOOGLE_CAPTCHA);
        }
    }
}
