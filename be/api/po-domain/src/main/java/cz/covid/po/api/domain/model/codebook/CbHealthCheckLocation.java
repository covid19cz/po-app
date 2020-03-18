package cz.covid.po.api.domain.model.codebook;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cb_health_check_location")
public class CbHealthCheckLocation extends CodebookItemBase {
    public static final String CODE = "cbHealthCheckLocation";
}
