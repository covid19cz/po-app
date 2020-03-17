package cz.covid.po.api.service;

import cz.covid.po.api.model.dto.CodebookValueDto;
import cz.covid.po.api.model.en.CodebookName;
import cz.covid.po.api.model.jpa.cb.CodebookValue;

import java.util.List;

public interface CodebookService {

    List<CodebookValueDto> getCodebookValues(CodebookName codebookName);

    CodebookValueDto createCodebookValue(CodebookName codebookName, CodebookValueDto codebookValueDto);

    CodebookValueDto updateCodebookValue(CodebookName codebookName, CodebookValueDto codebookValueDto);

    CodebookValueDto findCodebookValue(CodebookName codebookName, Long id);

    void deleteCodebookValue(CodebookName codebookName, Long id);

    CodebookValueDto mapToCodebookValueDto(CodebookValue codebookValue);

    <T> T getCodebookReference(CodebookName codebookName, Long id, Class<T> clazz);
}
