package de.muenchen.todo.dto;

import java.util.UUID;

public record SubTodoResponseWithoutParentDTO(UUID id, String name) {
}
