package cz.covid.po.api.service;

import cz.covid.po.api.model.dto.CodebookValueDto;
import cz.covid.po.api.model.en.CodebookName;
import cz.covid.po.api.model.jpa.cb.CodebookValue;

import java.util.List;

public interface CodebookService {

    List<CodebookValue> getCodebookValues(CodebookName codebookName);

    CodebookValue createCodebookValue(CodebookName codebookName, CodebookValue codebookValueDto);

    CodebookValue updateCodebookValue(CodebookName codebookName, CodebookValue codebookValueDto);

    CodebookValue findCodebookValue(CodebookName codebookName, Long id);

    void deleteCodebookValue(CodebookName codebookName, Long id);

    <T> T getCodebookReference(CodebookName codebookName, Long id, Class<T> clazz);

    CodebookValueDto mapToCodebookValueDto(CodebookValue codebookValue);

}
