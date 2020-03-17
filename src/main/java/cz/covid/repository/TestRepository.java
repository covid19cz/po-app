package cz.covid.repository;

import cz.covid.model.jpa.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
