package de.muenchen.todo.dto;

import java.util.UUID;

public record TodoResponseWithoutSubDTO(UUID id, String name) {
}
