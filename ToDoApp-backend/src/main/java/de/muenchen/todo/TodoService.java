package de.muenchen.todo;

import de.muenchen.todo.dto.SubTodoRequestDTO;
import de.muenchen.todo.dto.TodoMapper;
import de.muenchen.todo.dto.TodoRequestDTO;
import de.muenchen.todo.dto.TodoResponseDTO;

import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;
    private final SubTodoRepository subTodoRepository;
    private final TodoMapper todoMapper;

    public List<TodoResponseDTO> getAllTodos() {
        return StreamSupport.stream(todoRepository.findAll().spliterator(), false)
                .map(todoMapper::toDTO)
                .toList();
    }

    public TodoResponseDTO getTodo(final UUID uuid) {
        return todoRepository.findById(uuid)
                .map(todoMapper::toDTO)
                .orElse(null);
    }

    public UUID createTodo(final TodoRequestDTO todoRequestDTO) {
        return todoRepository.save(todoMapper.toEntity(todoRequestDTO)).getId();
    }

    public UUID createSubToDo(final SubTodoRequestDTO subTodoRequestDTO) {
        return subTodoRepository.save(todoMapper.toEntity(subTodoRequestDTO)).getId();
    }

}
