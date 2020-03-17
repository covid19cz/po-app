package cz.covid.po.api.integration.profisms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SendSmsRequest {

    @JsonProperty("CTRL")
    private String ctrl;

    @JsonProperty("_service")
    private String service;

    @JsonProperty("_call")
    private String call;

    @JsonProperty("_login")
    private String login;

    @JsonProperty("_password")
    private String password;

    private String text;

    @JsonProperty("msisdn")
    private String phone;

    private String source;

    public SendSmsRequest(String login, String encryptedPassword, String text, String phone, String callId, String source) {
        this.ctrl = "sms";
        this.service = "sms";
        this.call = callId;
        this.login = login;
        this.password = encryptedPassword;
        this.text = text;
        this.phone = phone;
        this.source = source;
    }

    public String getCtrl() {
        return ctrl;
    }

    public String getService() {
        return service;
    }

    public String getCall() {
        return call;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getText() {
        return text;
    }

    public String getPhone() {
        return phone;
    }

    public String getSource() {
        return source;
    }
}
