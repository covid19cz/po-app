package cz.covid.po.api.controller;

import cz.covid.po.api.bl.service.CodebookService;
import cz.covid.po.api.converter.CodebookConvertor;
import cz.covid.po.api.generated.controller.CodebookControllerApi;
import cz.covid.po.api.generated.dto.CodebookItemDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CodebookController extends ControllerBase implements CodebookControllerApi {

    private final CodebookService codebookService;
    private final CodebookConvertor codebookConvertor;

    @Override
    public ResponseEntity<List<CodebookItemDto>> getCodebookItemsUsingGET(String codebook) {
        return ResponseEntity.ok(codebookConvertor.convert(codebookService.getCodebookItems(getCodebookName(codebook))));
    }

    private String getCodebookName(String value) {
        if (value == null) {
            return null;
        }
        return value.replace("\"", "");
    }
}
