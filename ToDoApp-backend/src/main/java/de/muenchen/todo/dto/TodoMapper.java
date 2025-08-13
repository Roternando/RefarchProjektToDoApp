package de.muenchen.todo.dto;

import de.muenchen.todo.SubTodoEntity;
import de.muenchen.todo.TodoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    TodoEntity toEntity(TodoRequestDTO todoRequestDTO);

    TodoEntity toEntity(TodoResponseWithoutSubDTO todoResponseWithoutSubDTO);

    SubTodoEntity toEntity(SubTodoRequestDTO subTodoRequestDTO);

    TodoResponseWithSubDTO toTodoResponseWithSubDTO(TodoEntity todoEntity);

    TodoResponseWithoutSubDTO toTodoResponseWithoutSubDTO(TodoEntity todoEntity);

    SubTodoResponseWithParentDTO toSubTodoResponseWithParentDTO(SubTodoEntity subTodoEntity);

    SubTodoResponseWithoutParentDTO toSubTodoResponseWithoutParentDTO(SubTodoEntity subTodoEntity);
}
