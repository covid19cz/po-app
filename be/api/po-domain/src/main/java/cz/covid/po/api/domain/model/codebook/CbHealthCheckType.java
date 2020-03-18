package cz.covid.po.api.domain.model.codebook;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cb_health_check_type")
public class CbHealthCheckType extends CodebookItemBase {
    public static final String CODE = "cbHealthCheckType";
}
