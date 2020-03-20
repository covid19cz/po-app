package cz.covid.po.api.domain.model.codebook;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cb_health_status")
public class CbHealthStatus extends CodebookItemBase {
    public static final String CODE = "cbHealthStatus";

    public final class Items {
        public static final String UNKNOWN = "UNKNOWN";
        public static final String POSITIVE = "COVID19-POSITIVE";
        public static final String NEGATIVE = "COVID19-NEGATIVE";
        public static final String QUARANTINE = "QUARANTINE";
        public static final String NO_SYMPTOMS = "NO_SYMPTOMS";

    }
}
