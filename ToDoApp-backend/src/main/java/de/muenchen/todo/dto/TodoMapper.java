package de.muenchen.todo.dto;

import de.muenchen.todo.SubTodoEntity;
import de.muenchen.todo.TodoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    TodoEntity toEntity(TodoRequestDTO todoRequestDTO);

    SubTodoEntity toEntity(SubTodoRequestDTO subTodoRequestDTO);

    TodoResponseWithSubDTO toTodoResponseWithSubDTO(TodoEntity todoEntity);

    TodoResponseWithoutSubDTO toTodoResponseWithoutSubDTO(TodoEntity todoEntity);

    @Mapping(target = "parent", source = "parentTodoEntity")
    SubTodoResponseWithParentDTO toSubTodoResponseWithParentDTO(SubTodoEntity subTodoEntity);

    SubTodoResponseWithoutParentDTO toSubTodoResponseWithoutParentDTO(SubTodoEntity subTodoEntity);

    List<SubTodoEntity> toSubTodos(List<SubTodoRequestDTO> subTodoRequestDTOS);

    List<SubTodoResponseWithParentDTO> SubTodoResponseWithParentDTO(List<SubTodoEntity> subTodoEntities);

}
