package cz.covid.service;

import cz.covid.model.dto.CodebookValueDto;
import cz.covid.model.en.CodebookName;
import cz.covid.model.exception.NotFoundException;
import cz.covid.model.jpa.cb.CodebookValue;
import cz.covid.repository.cb.CodebookValueRepository;
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
    public List<CodebookValueDto> getCodebookValues(CodebookName codebookName) {
        List<CodebookValue> all = this.getCodebookRepository(codebookName).findAll();
        return all
                .stream()
                .map(this::mapToCodebookValueDto)
                .collect(Collectors.toList());
    }

    @Override
    public CodebookValueDto createCodebookValue(CodebookName codebookName, CodebookValueDto codebookValueDto) {
        CodebookValue codebookValue = this.mapToCodebookValue(codebookValueDto, this.getCodebookValueInstance(codebookName));
        codebookValue.setCreatedAt(new Date());
        this.getCodebookRepository(codebookName).save(codebookValue);
        return this.mapToCodebookValueDto(codebookValue);
    }

    @Override
    public CodebookValueDto findCodebookValue(CodebookName codebookName, Long id) {
        return this.mapToCodebookValueDto(this.findInternal(codebookName, id));
    }

    @Override
    @Transactional
    public CodebookValueDto updateCodebookValue(CodebookName codebookName, CodebookValueDto codebookValueDto) {
        CodebookValue codebookValue = this.findInternal(codebookName, codebookValueDto.getId());
        codebookValue.setName(codebookValueDto.getName());
        codebookValue.setModifiedAt(new Date());
        this.getCodebookRepository(codebookName).save(codebookValue);
        return this.mapToCodebookValueDto(codebookValue);
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

    @Override
    public CodebookValueDto mapToCodebookValueDto(CodebookValue codebookValue) {
        CodebookValueDto codebookValueDto = new CodebookValueDto();
        BeanUtils.copyProperties(codebookValue, codebookValueDto);
        return codebookValueDto;
    }

    private CodebookValue mapToCodebookValue(CodebookValueDto codebookValueDto, CodebookValue codebookValue) {
        BeanUtils.copyProperties(codebookValueDto, codebookValue, "id");
        return codebookValue;
    }

    private CodebookValue mapToCodebookValue(CodebookValueDto codebookValueDto) {
        return this.mapToCodebookValue(codebookValueDto, new CodebookValue());
    }

    private CodebookValue getCodebookValueInstance(CodebookName codebookName) {
        try {
            return codebookName.getClazz().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
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
}
