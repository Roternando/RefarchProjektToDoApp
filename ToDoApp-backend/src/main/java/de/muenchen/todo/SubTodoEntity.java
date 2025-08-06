package de.muenchen.todo;

import de.muenchen.common.BaseEntity;
import jakarta.persistence.Entity;

import java.io.Serial;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SubTodoEntity extends BaseEntity {
    @ManyToOne
    TodoEntity parent;
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
}
