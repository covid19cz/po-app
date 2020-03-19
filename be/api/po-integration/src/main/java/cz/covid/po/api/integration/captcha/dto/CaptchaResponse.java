package cz.covid.po.api.integration.captcha.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CaptchaResponse {
    private boolean success;
    @JsonProperty("challenge_ts")
    private LocalDateTime challengeTs;
    private String hostname;
    @JsonProperty("error-codes")
    private List<String> errorCodes;
}
