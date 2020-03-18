package cz.covid.po.api.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "po_address")
@SequenceGenerator(name = "po_address_seq_gen", sequenceName = "po_address_seq", allocationSize = 1)
public class Address extends EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "po_address_seq_gen")
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "number_descriptive")
    private String numberDescriptive;

    @Column(name = "number_evidence")
    private String numberEvidence;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_code")
    private String zipCode;
}
