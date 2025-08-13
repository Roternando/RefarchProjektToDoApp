package de.muenchen.todo;

import de.muenchen.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@Entity
@Getter
@Setter
public class SubTodoEntity extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentTodoEntity_id")
    private TodoEntity parentTodoEntity;
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
}
