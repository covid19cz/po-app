package cz.covid.model.jpa;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "RISKY_AREA_VISIT")
public class RiskyAreaVisit extends Meta {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "FROM_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date from;

    @Column(name = "TO_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date to;

    @Column(name = "REPORTED_TO_AUTHORITIES")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reportedToAuthorities;

    @Column(name = "SEVERITY", precision = 5, scale = 4)
    private BigDecimal severity;

    @ElementCollection
    @MapKeyColumn(name = "KEY")
    @Column(name = "VALUE")
    @CollectionTable(name = "RISKY_AREA_VISIT_DATA", joinColumns = @JoinColumn(name = "RISKY_AREA_VISIT_ID"))
    private Map<String, String> areaData = new HashMap<>();

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

    public Date getReportedToAuthorities() {
        return reportedToAuthorities;
    }

    public void setReportedToAuthorities(Date reportedToAuthorities) {
        this.reportedToAuthorities = reportedToAuthorities;
    }

    public BigDecimal getSeverity() {
        return severity;
    }

    public void setSeverity(BigDecimal severity) {
        this.severity = severity;
    }

    public Map<String, String> getAreaData() {
        return areaData;
    }

    public void setAreaData(Map<String, String> areaData) {
        this.areaData = areaData;
    }
}
