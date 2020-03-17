package cz.covid.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CodebookValueDto extends MetaDto {

    private Long id;

    @NotNull
    @Size(min = 1, max = 255)
    private String code;

    @Size(max = 1024)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
