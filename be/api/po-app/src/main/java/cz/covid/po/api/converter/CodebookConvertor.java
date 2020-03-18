package cz.covid.po.api.converter;

import cz.covid.po.api.domain.model.codebook.CodebookItemBase;
import cz.covid.po.api.generated.dto.CodebookItemDto;
import org.springframework.stereotype.Component;

@Component
public class CodebookConvertor extends OneWayConverterBase<CodebookItemBase, CodebookItemDto> {

    protected CodebookItemDto convertInternal(CodebookItemBase codebookValue) {
        CodebookItemDto result = new CodebookItemDto();
        result.setCode(codebookValue.getId());
        result.setOrder(codebookValue.getOrder());
        result.setText(codebookValue.getText());

        return result;
    }
}
