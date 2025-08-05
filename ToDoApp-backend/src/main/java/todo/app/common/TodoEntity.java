package todo.app.common;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class TodoEntity extends BaseEntity {
    private String name;
    @OneToMany
    private List<TodoEntity> subToDos;
}
