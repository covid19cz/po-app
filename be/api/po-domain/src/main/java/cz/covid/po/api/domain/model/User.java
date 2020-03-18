package cz.covid.po.api.domain.model;

import cz.covid.po.api.domain.model.enumeration.AuthRole;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "po_user")
@SequenceGenerator(name = "po_user_seq_gen", sequenceName = "po_user_seq", allocationSize = 1)
public class User extends EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "po_user_seq_gen")
    private Long id;

    private String login;

    private String password;

    @Enumerated(EnumType.STRING)
    private AuthRole role;

    private int invalidLoginAttempts;

}
