package cz.covid.po.api.domain.model;

import cz.covid.po.api.domain.model.HealtCheck;
import cz.covid.po.api.domain.model.Person;
import cz.covid.po.api.domain.model.codebook.CbRiskArea;
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
@Table(name = "po_visited_area")
@SequenceGenerator(name = "po_visited_area_seq_gen", sequenceName = "po_visited_area_seq", allocationSize = 1)
public class VisitedRiskArea {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "po_visited_area_seq_gen")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "health_check_id")
    private HealtCheck healthCheck;

    @ManyToOne
    @JoinColumn(name = "cb_risk_area")
    private CbRiskArea riskArea;
}
