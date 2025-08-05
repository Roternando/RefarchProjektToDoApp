package todo.app.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import todo.app.common.dto.TodoDTO;
import todo.app.common.dto.TodoMapper;
import todo.app.repository.TodoRepository;

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

    public TodoDTO getTodo(UUID uuid) {
        return todoRepository.findById(uuid)
                .map(todoMapper::toDTO)
                .orElse(null);
    }
}
