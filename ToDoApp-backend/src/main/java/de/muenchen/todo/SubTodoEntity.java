package de.muenchen.todo;

import de.muenchen.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serial;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SubTodoEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "parentTodoEntity")
    private TodoEntity parentTodoEntity;
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
}
