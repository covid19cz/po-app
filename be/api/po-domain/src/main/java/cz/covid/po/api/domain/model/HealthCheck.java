package cz.covid.po.api.domain.model;

import cz.covid.po.api.domain.converter.LocalDateAttributeConverter;
import cz.covid.po.api.domain.model.codebook.CbHealthCheckLocation;
import cz.covid.po.api.domain.model.codebook.CbHealthCheckType;
import cz.covid.po.api.domain.model.codebook.CbRiskArea;
import cz.covid.po.api.domain.model.enumeration.SymptomsEnum;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Entity
@Getter
@Setter
@Table(name = "po_health_check")
@SequenceGenerator(name = "po_health_check_seq_gen", sequenceName = "po_health_check_seq", allocationSize = 1)
public class HealthCheck extends EntityBase {
    @Id()
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "po_health_check_seq_gen")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "fk_po_health_check_po_person"))
    private Person person;

    @Column(name = "symtomps_since", columnDefinition = "DATE")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate symtompsSince;

    @Column(name = "high_temperature_duration")
    @Enumerated(EnumType.STRING)
    private SymptomsEnum highTemperatureDuration;

    @Column(name = "dry_cough_duration")
    @Enumerated(EnumType.STRING)
    private SymptomsEnum dryCoughDuration;

    @Column(name = "headache")
    @Type(type = "yes_no")
    private Boolean headache;

    @Column(name = "infected_in_contact")
    private String infectedInContact;

    @Column(name = "infected_in_contact_date", columnDefinition = "DATE")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate infectedInContactDate;

    @Column(name = "infected_phone_numbers")
    private String infectedPhoneNumbers;

    @ManyToOne
    @JoinColumn(name = "preferred_health_check_location", foreignKey = @ForeignKey(name = "fk_po_health_check_preffered_location_cb_health_check_location"))
    private CbHealthCheckLocation preferredHealthCheckLocation;

    @Column(name = "able_to_drive")
    @Type(type = "yes_no")
    private Boolean ableToDrive;

    @Column(name = "health_check_code")
    private String healthCheckCode;

    @ManyToOne
    @JoinColumn(name = "health_check_type", foreignKey = @ForeignKey(name = "fk_po_health_check_cb_health_check_type"))
    private CbHealthCheckType healthCheckType;

    @ManyToOne
    @JoinColumn(name = "final_health_check_location", foreignKey = @ForeignKey(name = "fk_po_health_check_final_location_cb_health_check_location"))
    private CbHealthCheckLocation finalHealthCheckLocation;

    @OneToMany(mappedBy = "healthCheck", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("resultDate")
    private List<HealthCheckResult> healthCheckResults = new LinkedList<>();

    @ManyToOne
    @JoinColumn(name = "visited_risk_area_id", foreignKey = @ForeignKey(name = "fk_po_health_check_final_location_cb_health_check_location"))
    private CbRiskArea visitedRiskArea;
}
