package cz.covid.po.api.domain.repository;

import cz.covid.po.api.domain.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
