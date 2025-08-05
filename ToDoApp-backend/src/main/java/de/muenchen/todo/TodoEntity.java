package de.muenchen.todo;

import de.muenchen.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.io.Serial;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class TodoEntity extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    @OneToMany
    private List<TodoEntity> subToDos;
}
