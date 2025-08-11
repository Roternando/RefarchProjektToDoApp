package de.muenchen.todo;

import de.muenchen.todo.dto.SubTodoRequestDTO;
import de.muenchen.todo.dto.SubTodoResponseWithParentDTO;
import de.muenchen.todo.dto.TodoMapper;
import de.muenchen.todo.dto.TodoRequestDTO;
import de.muenchen.todo.dto.TodoResponseWithSubDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;
    private final SubTodoRepository subTodoRepository;
    private final TodoMapper todoMapper;

    public TodoResponseWithSubDTO createTodo(final TodoRequestDTO todoRequestDTO) {

        final TodoEntity todoEntity = todoMapper.toEntity(todoRequestDTO);

        final List<SubTodoEntity> subTodoEntities = todoRequestDTO.subTodos().stream()
                .map(subTodoDTO -> {
                    final SubTodoEntity subTodoEntity = todoMapper.toEntity(subTodoDTO);
                    subTodoEntity.setParentTodoEntity(todoEntity);
                    return subTodoEntity;
                })
                .collect(Collectors.toList());

        todoEntity.setSubTodos(subTodoEntities);
        todoRepository.save(todoEntity);
        subTodoRepository.saveAll(subTodoEntities);

        return todoMapper.toTodoResponseWithSubDTO(todoEntity);
    }

    public SubTodoResponseWithParentDTO createSubToDo(final SubTodoRequestDTO subTodoRequestDTO) {
        final SubTodoEntity subTodoEntity = subTodoRepository.save(todoMapper.toEntity(subTodoRequestDTO));
        return todoMapper.toSubTodoResponseWithParentDTO(subTodoEntity);
    }

    public TodoResponseWithSubDTO getTodo(final UUID uuid) {
        return todoRepository.findById(uuid)
                .map(todoMapper::toTodoResponseWithSubDTO)
                .orElse(null);
    }

    public SubTodoResponseWithParentDTO getSubTodo(final UUID uuid) {
        return subTodoRepository.findById(uuid)
                .map(todoMapper::toSubTodoResponseWithParentDTO)
                .orElse(null);
    }

    public List<TodoResponseWithSubDTO> getAllTodos() {
        return StreamSupport.stream(todoRepository.findAll().spliterator(), false)
                .map(todoMapper::toTodoResponseWithSubDTO)
                .toList();
    }

    public List<SubTodoResponseWithParentDTO> getAllSubTodos() {
        return StreamSupport.stream(subTodoRepository.findAll().spliterator(), false)
                .map(todoMapper::toSubTodoResponseWithParentDTO)
                .toList();
    }

    public void removeAllTodos() {
        todoRepository.deleteAll();
    }

    public void removeAllSubTodos() {
        subTodoRepository.deleteAll();
    }
}
