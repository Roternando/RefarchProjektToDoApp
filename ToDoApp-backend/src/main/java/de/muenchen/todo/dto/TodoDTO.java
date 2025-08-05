package de.muenchen.todo.dto;

import java.util.List;
import java.util.UUID;

public record TodoDTO(UUID id, String name, List<TodoDTO> subToDos) {
}
