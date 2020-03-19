package cz.covid.po.api.controller;

import cz.covid.po.api.bl.service.LoginService;
import cz.covid.po.api.bl.service.PersonService;
import cz.covid.po.api.domain.model.Person;
import cz.covid.po.api.generated.controller.AuthorizationControllerApi;
import cz.covid.po.api.generated.dto.SendCodeRequest;
import cz.covid.po.api.generated.dto.SendCodeResponse;
import cz.covid.po.api.generated.dto.VerifyCodeResponseDto;
import cz.covid.po.api.helper.PhoneNormalizerHelper;
import cz.covid.po.api.validator.PhoneValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AuthorizationController extends ControllerBase implements AuthorizationControllerApi {

    private final PersonService personService;
    private final LoginService loginService;
    private final PhoneValidator phoneValidator;
    private final PhoneNormalizerHelper phoneNormalizer;

    @Override
    public ResponseEntity<SendCodeResponse> sendCodeUsingPOST(SendCodeRequest sendCodeRequest) {
        final String normalizedPhone = phoneNormalizer.normalizePhone(sendCodeRequest.getPhoneNumber());
        phoneValidator.validatePhone(normalizedPhone);
        Person person = personService.getOrCreate(normalizedPhone);
        loginService.sendAuthSms(person.getUid());

        return ResponseEntity.ok(new SendCodeResponse().personUid(person.getUid()));
    }

    @Override
    public ResponseEntity<VerifyCodeResponseDto> verifyCodeUsingPOST(UUID personUid, String smsCode) {
        return ResponseEntity.ok(new VerifyCodeResponseDto().password(loginService.verifyCode(personUid, smsCode)));
    }
}
