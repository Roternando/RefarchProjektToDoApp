package de.muenchen.todo.dto;

import java.util.List;
import java.util.UUID;

public record TodoResponseWithSubDTO(UUID id, String name, List<SubTodoResponseWithoutParentDTO> subTodos) {
}
