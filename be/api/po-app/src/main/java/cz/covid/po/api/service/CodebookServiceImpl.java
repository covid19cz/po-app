package cz.covid.po.api.service;

import cz.covid.po.api.model.dto.CodebookValueDto;
import cz.covid.po.api.model.en.CodebookName;
import cz.covid.po.api.model.exception.NotFoundException;
import cz.covid.po.api.model.jpa.cb.CodebookValue;
import cz.covid.po.api.repository.cb.CodebookValueRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class CodebookServiceImpl implements CodebookService, InitializingBean {

    private ApplicationContext applicationContext;
    private Map<CodebookName, CodebookValueRepository> codebookToRepositoryMapping = new HashMap<>();

    @Autowired
    public CodebookServiceImpl(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CodebookValue> getCodebookValues(CodebookName codebookName) {
        return (List<CodebookValue>) this.getCodebookRepository(codebookName).findAll();
    }

    @Override
    public CodebookValue createCodebookValue(CodebookName codebookName, CodebookValue codebookValue) {
        codebookValue.setCreatedAt(new Date());
        this.getCodebookRepository(codebookName).save(codebookValue);
        return codebookValue;
    }

    @Override
    public CodebookValue findCodebookValue(CodebookName codebookName, Long id) {
        return this.findInternal(codebookName, id);
    }

    @Override
    @Transactional
    public CodebookValue updateCodebookValue(CodebookName codebookName, CodebookValue codebookValueDto) {
        CodebookValue codebookValue = this.findInternal(codebookName, codebookValueDto.getId());
        codebookValue.setName(codebookValueDto.getName());
        codebookValue.setModifiedAt(new Date());
        this.getCodebookRepository(codebookName).save(codebookValue);
        return codebookValue;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void deleteCodebookValue(CodebookName codebookName, Long id) {
        this.getCodebookRepository(codebookName).deleteById(id);
    }

    @SuppressWarnings("unchecked")
    private CodebookValue findInternal(CodebookName codebookName, Long id) {
        Optional<CodebookValue> byId = this.getCodebookRepository(codebookName).findById(id);
        return byId.orElseThrow(() -> new NotFoundException("Codebook value for given id could not be found"));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getCodebookReference(CodebookName codebookName, Long id, Class<T> clazz) {
        return (T) this.getCodebookRepository(codebookName).getOne(id);
    }

    private CodebookValueRepository getCodebookRepository(CodebookName codebookName) {
        return codebookToRepositoryMapping.get(codebookName);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for (CodebookName codebookName : CodebookName.values()) {
            codebookToRepositoryMapping.put(codebookName, applicationContext.getBean(codebookName.getRepositoryClazz()));
        }
    }

    @Override
    public CodebookValueDto mapToCodebookValueDto(CodebookValue codebookValue) {
        CodebookValueDto codebookValueDto = new CodebookValueDto();
        BeanUtils.copyProperties(codebookValue, codebookValueDto);
        return codebookValueDto;
    }
}
