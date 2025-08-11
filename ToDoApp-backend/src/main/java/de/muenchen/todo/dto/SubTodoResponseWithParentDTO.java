package de.muenchen.todo.dto;

import java.util.UUID;

public record SubTodoResponseWithParentDTO(UUID id, TodoResponseWithSubDTO parent, String name) {
}
