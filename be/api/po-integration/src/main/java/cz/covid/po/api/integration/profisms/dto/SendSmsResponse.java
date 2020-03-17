package cz.covid.po.api.integration.profisms.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SendSmsResponse {

    private SmsResponseData data;
    private Error error;

    public SmsResponseData getData() {
        return data;
    }

    public Error getError() {
        return error;
    }
}
