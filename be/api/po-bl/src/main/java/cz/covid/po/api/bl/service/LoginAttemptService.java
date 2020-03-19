package cz.covid.po.api.bl.service;

public interface LoginAttemptService {
    void loginFailed(String username);

    void success(String username);
}
