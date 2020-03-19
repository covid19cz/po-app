package cz.covid.po.api.domain.model;

import cz.covid.po.api.domain.model.enumeration.AuthorizationState;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
@Table(name = "po_authorization")
@SequenceGenerator(name = "po_authorization_seq_gen", sequenceName = "po_authorization_seq", allocationSize = 1)
public class Authorization extends EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "po_authorization_seq_gen")
    private Long id;

    @JoinColumn(name = "person_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;

    private String code;

    private int attempts;

    @Enumerated(EnumType.STRING)
    private AuthorizationState state;

}
