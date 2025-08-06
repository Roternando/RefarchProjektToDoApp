package de.muenchen.todo.dto;

import de.muenchen.todo.SubTodoEntity;
import de.muenchen.todo.TodoEntity;
import org.mapstruct.Mapper;

@Mapper
public interface TodoMapper {
    TodoEntity toEntity(TodoRequestDTO todoRequestDTO);

    SubTodoEntity toEntity(SubTodoRequestDTO todoRequestDTO);

    TodoResponseDTO toDTO(TodoEntity todoEntity);

    SubTodoResponseDTO toDTO(SubTodoEntity subTodoEntity);
}
