package cz.covid.po.api.domain.model;

import cz.covid.po.api.domain.model.codebook.CbHealthStatus;
import java.time.OffsetDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "po_person")
@SequenceGenerator(name = "po_person_seq_gen", sequenceName = "po_person_seq", allocationSize = 1)
public class Person extends EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "po_person_seq_gen")
    private Long id;

    @Column(name = "uid")
    private UUID uid;

    @Column(name = "return_hash")
    private String returnHash;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "address_home_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "health_status")
    private CbHealthStatus healthStatus;

    @Column(name = "health_status_last_change", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime healthStatusLastChange;
}
