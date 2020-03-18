package cz.covid.po.api.domain.model.codebook;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class CodebookItemBase {
    @Id
    private String id;

    @Column(name = "item_order")
    private int order;

    @Column(name = "default_item")
    private boolean defaultItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codebook_id", updatable = false, nullable = false)
    private Codebook codebook;

    private String text;

    /**
     * This equals and hashcode is overridden because of comparision methods used in code.
     * Two codebookItems are equals if they have same codebook and same id.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !getClass().isAssignableFrom(o.getClass())) {
            return false;
        }
        CodebookItemBase that = (CodebookItemBase) o;
        return getId().equals(that.getId())
                && getCodebook().equals(that.getCodebook());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codebook);
    }
}
