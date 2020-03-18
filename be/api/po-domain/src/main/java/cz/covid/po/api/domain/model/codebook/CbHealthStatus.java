package cz.covid.po.api.domain.model.codebook;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cb_health_status")
public class CbHealthStatus extends CodebookItemBase {
    public static final String CODE = "cbHealthStatus";
}
