package cz.covid.po.api.domain.repository.codebook;

import cz.covid.po.api.domain.model.codebook.CodebookItemBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CodebookItemRepository<T extends CodebookItemBase> extends JpaRepository<T, String> {
}
