package cz.covid.po.api.domain.repository.codebook;

import cz.covid.po.api.domain.model.codebook.Codebook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodebookRepository extends JpaRepository<Codebook, String> {
}
