package de.muenchen.todo;

import de.muenchen.todo.dto.CreateTodoDTO;
import de.muenchen.todo.dto.TodoDTO;
import de.muenchen.todo.dto.TodoMapper;
import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    public List<TodoDTO> getAllTodos() {
        return StreamSupport.stream(todoRepository.findAll().spliterator(), false)
                .map(todoMapper::toDTO)
                .toList();
    }

    public TodoDTO getTodo(final UUID uuid) {
        return todoRepository.findById(uuid)
                .map(todoMapper::toDTO)
                .orElse(null);
    }

    public UUID createTodo(final CreateTodoDTO createTodoDTO) {
        return todoRepository.save(todoMapper.toEntity(createTodoDTO)).getId();
    }
}
