package cz.covid.model.dto;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class ConsentDto {

    private Long id;
    @NotNull
    private Date date;
    @NotNull
    private CodebookValueDto consentType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CodebookValueDto getConsentType() {
        return consentType;
    }

    public void setConsentType(CodebookValueDto consentType) {
        this.consentType = consentType;
    }
}
