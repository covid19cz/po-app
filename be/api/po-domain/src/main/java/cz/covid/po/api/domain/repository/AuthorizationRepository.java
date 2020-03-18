package cz.covid.po.api.domain.repository;

import cz.covid.po.api.domain.model.Authorization;
import cz.covid.po.api.domain.model.Person;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {

    Optional<Authorization> findFirstByPersonOrderByCreatedAtDesc(Person client);

    @Query("FROM Authorization auth WHERE auth.person.id = :personId AND auth.createdAt >= :time ORDER BY auth.createdAt DESC")
    List<Authorization> findAfterTimeDesc(@Param("personId") Long personId, @Param("time") OffsetDateTime time);

    @Query("FROM Authorization auth WHERE auth.createdAt <= :time")
    List<Authorization> findBeforeTime(@Param("time") OffsetDateTime time);
}
