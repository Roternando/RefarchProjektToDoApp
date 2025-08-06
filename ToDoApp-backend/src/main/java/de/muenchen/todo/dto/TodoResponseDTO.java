package de.muenchen.todo.dto;

import java.util.List;
import java.util.UUID;

public record TodoResponseDTO(UUID id, String name, List<SubTodoResponseDTO> subTodos) {
}
