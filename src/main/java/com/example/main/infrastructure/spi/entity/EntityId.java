package com.example.main.infrastructure.spi.entity;

import com.example.main.domain.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Embeddable
@NoArgsConstructor
public class EntityId implements Serializable {
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    public EntityId(Id id) {
        this.id = id.getValue();
    }
}
