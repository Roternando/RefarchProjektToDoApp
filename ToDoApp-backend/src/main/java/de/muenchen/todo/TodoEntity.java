package de.muenchen.todo;

import de.muenchen.common.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.util.List;

@Entity
@Getter
@Setter
public class TodoEntity extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentTodoEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubTodoEntity> subTodos;
}
