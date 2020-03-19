package cz.covid.po.api.integration.profisms.service;

import cz.covid.po.api.integration.common.enumeration.IntegrationSystem;
import cz.covid.po.api.integration.common.exception.IntegrationException;
import cz.covid.po.api.integration.common.util.EncryptionUtil;
import cz.covid.po.api.integration.common.util.JsonMapperUtil;
import cz.covid.po.api.integration.common.util.UriParamUtil;
import cz.covid.po.api.integration.profisms.dto.SendSmsRequest;
import cz.covid.po.api.integration.profisms.dto.SendSmsResponse;
import cz.covid.po.api.integration.profisms.service.ProfiSmsSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.UUID;

/**
 * Dummy implementation that is doing nothing in test.
 */
@Service
@Profile("test")
public class ProfiSmsSenderDummy implements ProfiSmsSender {

    @Override
    public void sendSms(String phone, String message) {
    }

}
