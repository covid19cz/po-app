package cz.covid.po.api.bl.service;

import java.util.UUID;

public interface LoginService {

    /**
     * Send authorization sms and store it in DB.
     *
     * @param personUid uid of person
     */
    void sendAuthSms(UUID personUid);

    /**
     * Verify code from sms and return pass for user.
     *
     * @param personUid uid of a person
     * @param code      sms code
     *
     * @return {@link String}
     */
    String verifyCode(UUID personUid, String code);

    /**
     * Set password of user to default value.
     *
     * @param userId db id of user
     */
    void resetPassword(Long userId);
}
