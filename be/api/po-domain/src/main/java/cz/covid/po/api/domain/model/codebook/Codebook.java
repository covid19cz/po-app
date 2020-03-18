package cz.covid.po.api.domain.model.codebook;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cb__codebook")
public class Codebook {
    @Id
    private String id;
    private String name;
    private String description;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null || !getClass().isAssignableFrom(that.getClass())) {
            return false;
        }
        return getId().equals(((Codebook) that).getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
