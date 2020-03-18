package cz.covid.po.api.bl.service;

import cz.covid.po.api.domain.model.codebook.CbHealthCheckLocation;
import cz.covid.po.api.domain.model.codebook.CbHealthCheckType;
import cz.covid.po.api.domain.model.codebook.CbHealthStatus;
import cz.covid.po.api.domain.model.codebook.CbRiskArea;
import cz.covid.po.api.domain.model.codebook.CodebookItemBase;
import cz.covid.po.api.domain.repository.codebook.CbHealthCheckLocationRepository;
import cz.covid.po.api.domain.repository.codebook.CbHealthCheckTypeRepository;
import cz.covid.po.api.domain.repository.codebook.CbHealthStatusRepository;
import cz.covid.po.api.domain.repository.codebook.CbRiskAreaRepository;
import cz.covid.po.api.domain.repository.codebook.CodebookItemRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@SuppressWarnings("rawtypes")
public class CodebookServiceImpl implements CodebookService {

    private final ApplicationContext applicationContext;

    private Map<String, CodebookRegistration> registeredCodebooks = Map.of(
            CbHealthStatus.CODE, new CodebookRegistration(CbHealthStatus.class, CbHealthStatusRepository.class),
            CbHealthCheckType.CODE, new CodebookRegistration(CbHealthCheckType.class, CbHealthCheckTypeRepository.class),
            CbHealthCheckLocation.CODE, new CodebookRegistration(CbHealthCheckLocation.class, CbHealthCheckLocationRepository.class),
            CbRiskArea.CODE, new CodebookRegistration(CbRiskArea.class, CbRiskAreaRepository.class)
    );

    private Map<String, CodebookItemRepository> codebookRepositories = new HashMap<>();

    @PostConstruct
    public void init() {
        for (Map.Entry<String, CodebookRegistration> cb : registeredCodebooks.entrySet()) {
            codebookRepositories.put(cb.getKey(), applicationContext.getBean(cb.getValue().getRepositoryClass()));
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CodebookItemBase> getCodebookItems(String codebook) {
        return (List<CodebookItemBase>) codebookRepositories.get(codebook).findAll();
    }

    @Getter
    @AllArgsConstructor
    private static class CodebookRegistration {
        private Class<? extends CodebookItemBase> codebookClass;
        private Class<? extends CodebookItemRepository> repositoryClass;
    }
}
