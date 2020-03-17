package cz.covid.po.api.repository.cb;

import cz.covid.po.api.model.jpa.cb.CodebookValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface CodebookValueRepository<T extends CodebookValue, E extends Serializable> extends JpaRepository<T, E> {

    Optional<T> findByCode(String code);
}
