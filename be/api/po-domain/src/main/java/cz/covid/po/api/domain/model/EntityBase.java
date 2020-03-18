package cz.covid.po.api.domain.model;

import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class EntityBase {

    @Column(name = "created_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime updatedAt;

    @PrePersist
    public void onInsert() {
        final OffsetDateTime sysdate = OffsetDateTime.now();
        setCreatedAt(sysdate);
        setUpdatedAt(sysdate);
    }

    @PreUpdate
    public void onUpdate() {
        setUpdatedAt(OffsetDateTime.now());
    }
}
