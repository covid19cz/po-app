package cz.covid.po.api.integration.captcha.service;

public interface CaptchaValidator {
    /**
     * Verify google captcha
     *
     * @param userToken The user response token provided by the reCAPTCHA client-side integration
     * @param remoteIp Optional param of the users ip address
     */
    boolean verifyCaptcha(final String userToken,final String remoteIp);
}
