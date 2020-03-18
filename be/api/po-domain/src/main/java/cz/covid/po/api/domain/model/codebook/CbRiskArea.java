package cz.covid.po.api.domain.model.codebook;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cb_risk_area")
public class CbRiskArea extends CodebookItemBase {
    public static final String CODE = "cbRiskArea";
}
