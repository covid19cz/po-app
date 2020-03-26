package cz.covid.po.api.integration.profisms.service;

import cz.covid.po.api.integration.common.enumeration.IntegrationSystem;
import cz.covid.po.api.integration.common.exception.IntegrationException;
import cz.covid.po.api.integration.common.util.EncryptionUtil;
import cz.covid.po.api.integration.common.util.JsonMapperUtil;
import cz.covid.po.api.integration.common.util.UriParamUtil;
import cz.covid.po.api.integration.profisms.dto.SendSmsRequest;
import cz.covid.po.api.integration.profisms.dto.SendSmsResponse;
import java.io.IOException;
import java.util.UUID;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Profile("!test")
public class ProfiSmsSenderImpl implements ProfiSmsSender {

    private static final int PROFI_SMS_OK = 0;

    @Value("${app.integration.profi-sms.base-url}")
    private String baseUrl;
    @Value("${app.integration.profi-sms.login}")
    private String login;
    @Value("${app.integration.profi-sms.password}")
    private String pass;
    @Value("${app.integration.profi-sms.source}")
    private String source;
    @Value("${app.integration.profi-sms.enabled}")
    private Boolean enabled;

    private WebClient webClient;

    @PostConstruct
    public void init() {
        webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    @Override
    public void sendSms(String phone, String message) {
        if (!enabled) {
            //log.debug("Sending sms is not enabled");
            return;
        }

        String callId = UUID.randomUUID().toString();
        //log.debug("Sending sms to number {} with text {} and callId={}", phone, message, callId);

        String encryptedPassword = EncryptionUtil.encryptMD5(pass + callId);
        SendSmsRequest request = new SendSmsRequest(login, encryptedPassword, message, phone, callId, source);
        ClientResponse response =
                webClient.get()
                        .uri(builder -> builder.queryParams(UriParamUtil.toParamMap(request))
                                .build())
                        .exchange()
                        .block();

        SendSmsResponse smsResponse = checkResponse(response);

        if (smsResponse != null && smsResponse.getError() != null) {
            if (smsResponse.getError().getCode() != PROFI_SMS_OK) {
                //log.error("Sms to {} with calId={} wasn't send correctly. Reason: {}", phone, callId, smsResponse.toString());
                throw new IntegrationException("ProfiSms response error", IntegrationSystem.PROFI_SMS);
            } else {
                //log.info("Sms sent correctly to number {} with callId={}", phone, callId);
            }
        } else {
            throw new IntegrationException("ProfiSms response error", IntegrationSystem.PROFI_SMS);
        }
    }

    private SendSmsResponse checkResponse(ClientResponse response) {
        if (response != null) {
            String stringResponse = response.bodyToMono(String.class).block();
            //log.debug("Response from ProfiSms: {}", stringResponse);
            if (response.statusCode().is2xxSuccessful()) {
                try {
                    return JsonMapperUtil.toObject(stringResponse, SendSmsResponse.class);
                } catch (IOException e) {
                    throw new IntegrationException("Error parsing response: " + stringResponse, e, IntegrationSystem.PROFI_SMS);
                }
            } else {
                throw new IntegrationException("Some error when trying send sms: " + stringResponse, IntegrationSystem.PROFI_SMS);
            }
        }
        throw new IntegrationException("ProfiSms return null", IntegrationSystem.PROFI_SMS);
    }
}
