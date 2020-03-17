package cz.covid.po.api.integration.profisms.service;

public interface ProfiSmsSender {

    /**
     * Send sms trough ProfiSMS.
     *
     * @param phone   Phone number in internation format +420xxxxxxxxx
     * @param message Sms message
     */
    void sendSms(String phone, String message);
}
