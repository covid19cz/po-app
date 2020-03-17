package cz.covid.service;

import cz.covid.model.dto.CodebookValueDto;
import cz.covid.model.en.CodebookName;
import cz.covid.model.jpa.cb.CodebookValue;

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
