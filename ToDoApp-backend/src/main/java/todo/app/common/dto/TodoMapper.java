package todo.app.common.dto;

import org.mapstruct.Mapper;
import todo.app.common.TodoEntity;

@Mapper
public interface TodoMapper {
    TodoEntity toEntity(TodoDTO dto);

    TodoDTO toDTO(TodoEntity entity);
}
