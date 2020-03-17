package cz.covid.controller;

import cz.covid.model.dto.CodebookValueDto;
import cz.covid.model.en.CodebookName;
import cz.covid.service.CodebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/codebook")
public class CodebookController {

    private CodebookService codebookService;

    @Autowired
    public CodebookController(CodebookService codebookService) {
        this.codebookService = codebookService;
    }

    @GetMapping(value = "/{codebookName}")
    public List<CodebookValueDto> getCodebookValues(@PathVariable CodebookName codebookName) {
        return codebookService.getCodebookValues(codebookName);
    }

    @GetMapping(value = "/{codebookName}/{id}")
    public CodebookValueDto findCodebookValues(@PathVariable CodebookName codebookName, @PathVariable Long id) {
        return codebookService.findCodebookValue(codebookName, id);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(value = "/{codebookName}")
    public CodebookValueDto createCodebookValue(@PathVariable CodebookName codebookName, @Valid @RequestBody CodebookValueDto codebookValueDto) {
        return codebookService.createCodebookValue(codebookName, codebookValueDto);
    }

    @PutMapping(value = "/{codebookName}/{id}")
    public CodebookValueDto updateCodebookValue(@PathVariable CodebookName codebookName, @PathVariable Long id, @Valid @RequestBody CodebookValueDto codebookValueDto) {
        codebookValueDto.setId(id);
        return codebookService.updateCodebookValue(codebookName, codebookValueDto);
    }

    @DeleteMapping(value = "/{codebookName}/{id}")
    public void deleteCodebookValue(@PathVariable CodebookName codebookName, @PathVariable Long id) {
        codebookService.deleteCodebookValue(codebookName, id);
    }


}
