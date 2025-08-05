package de.muenchen.todo.dto;

import java.util.List;

public record CreateTodoDTO(String name, List<TodoDTO> subToDos) {
}
