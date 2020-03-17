package cz.covid.po.api.converter;

import cz.covid.po.api.generated.dto.CodebookValueDto;
import cz.covid.po.api.model.jpa.cb.CodebookValue;
import org.springframework.stereotype.Component;

@Component
public class CodebookConvertor extends TwoWayConverterBase<CodebookValue, CodebookValueDto> {

    protected CodebookValueDto convertInternal(CodebookValue codebookValue) {
        if (codebookValue == null) {
            return null;
        }
        CodebookValueDto result = new CodebookValueDto();
        result.setCode(codebookValue.getCode());
        result.setId(codebookValue.getId());
        result.setName(codebookValue.getName());

        return result;
    }

    protected CodebookValue convertBackInternal(CodebookValueDto codebookValueDto) {
        if (codebookValueDto == null) {
            return null;
        }
        CodebookValue result = new CodebookValue();
        result.setCode(codebookValueDto.getCode());
        result.setId(codebookValueDto.getId());
        result.setName(codebookValueDto.getName());
        return result;
    }
}
