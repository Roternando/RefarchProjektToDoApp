package de.muenchen.todo.dto;

import java.util.List;

public record TodoRequestDTO(String name, List<SubTodoRequestDTO> subTodos) {
}
