package cz.covid.po.api.controller;

import cz.covid.po.api.converter.CodebookConvertor;
import cz.covid.po.api.generated.controller.CodebookControllerApi;
import cz.covid.po.api.model.en.CodebookName;
import cz.covid.po.api.service.CodebookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodebookController implements CodebookControllerApi {

    private CodebookService codebookService;
    private CodebookConvertor codebookConvertor;

    @Autowired
    public CodebookController(CodebookService codebookService, CodebookConvertor codebookConvertor) {
        this.codebookService = codebookService;
        this.codebookConvertor = codebookConvertor;
    }

    @Override
    public ResponseEntity<cz.covid.po.api.generated.dto.CodebookValueDto> createCodebookValueUsingPOST(String codebookName, cz.covid.po.api.generated.dto.CodebookValueDto codebookValueDto) {
        return ResponseEntity.ok(codebookConvertor.convert(codebookService.createCodebookValue(getCodebookName(codebookName), codebookConvertor.convertBack(codebookValueDto))));
    }

    @Override
    public ResponseEntity<Void> deleteCodebookValueUsingDELETE(String codebookName, Long id) {
        codebookService.deleteCodebookValue(getCodebookName(codebookName), id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<cz.covid.po.api.generated.dto.CodebookValueDto> findCodebookValuesUsingGET(String codebookName, Long id) {
        return ResponseEntity.ok(codebookConvertor.convert(codebookService.findCodebookValue(getCodebookName(codebookName), id)));
    }

    @Override
    public ResponseEntity<List<cz.covid.po.api.generated.dto.CodebookValueDto>> getCodebookValuesUsingGET(String codebookName) {
        return ResponseEntity.ok(codebookConvertor.convert(codebookService.getCodebookValues(getCodebookName(codebookName))));
    }

    @Override
    public ResponseEntity<cz.covid.po.api.generated.dto.CodebookValueDto> updateCodebookValueUsingPUT(String codebookName, cz.covid.po.api.generated.dto.CodebookValueDto codebookValueDto, Long id) {
        codebookValueDto.setId(id);
        return ResponseEntity.ok(codebookConvertor.convert(codebookService.updateCodebookValue(getCodebookName(codebookName), codebookConvertor.convertBack(codebookValueDto))));
    }

    private CodebookName getCodebookName(String value) {
        if (value == null) {
            return null;
        }
        return Enum.valueOf(CodebookName.class, value.replace("\"", ""));
    }
}
