package de.muenchen.todo.dto;

import de.muenchen.todo.TodoEntity;
import org.mapstruct.Mapper;

@Mapper
public interface TodoMapper {
    TodoEntity toEntity(TodoDTO dto);

    TodoEntity toEntity(CreateTodoDTO createTodoDTO);

    TodoDTO toDTO(TodoEntity entity);
}
