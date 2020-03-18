package cz.covid.po.api.domain.model;

import java.time.OffsetDateTime;
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
@Table(name = "po_health_check_result")
@SequenceGenerator(name = "po_health_check_result_seq_gen", sequenceName = "po_health_check_result_seq", allocationSize = 1)
public class HealtCheckResult {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "po_health_check_result_seq_gen")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "health_check_id")
    private HealtCheck healthCheck;

    @Column(name = "result_positive")
    private Boolean resultPositive;

    @Column(name = "result_date")
    private OffsetDateTime result_date;

    @Column(name = "result_sent_at")
    private OffsetDateTime resultSentAt;
}
