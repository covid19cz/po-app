package cz.covid.model.jpa;

import cz.covid.model.jpa.cb.SymptomType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "SYMPTOM")
public class Symptom extends Meta {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "FROM_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date from;

    @Column(name = "TO_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date to;

    @Column(name = "SEVERITY", precision = 5, scale = 4)
    private BigDecimal severity;

    @ManyToOne
    @JoinColumn(name = "SYMPTOM_TYPE_ID")
    private SymptomType symptomType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public SymptomType getSymptomType() {
        return symptomType;
    }

    public void setSymptomType(SymptomType symptomType) {
        this.symptomType = symptomType;
    }

    public BigDecimal getSeverity() {
        return severity;
    }

    public void setSeverity(BigDecimal severity) {
        this.severity = severity;
    }
}
