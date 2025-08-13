package de.muenchen.todo;

import de.muenchen.todo.dto.SubTodoRequestDTO;
import de.muenchen.todo.dto.SubTodoResponseWithParentDTO;
import de.muenchen.todo.dto.TodoMapper;
import de.muenchen.todo.dto.TodoRequestDTO;
import de.muenchen.todo.dto.TodoResponseWithSubDTO;
import de.muenchen.todo.dto.TodoResponseWithoutSubDTO;
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

    public TodoResponseWithSubDTO createTodoWithSubTodo(final TodoRequestDTO todoRequestDTO) {

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

        return todoMapper.toTodoResponseWithSubDTO(todoEntity);
    }

    public TodoResponseWithoutSubDTO createTodoWithoutSubTodo(final TodoRequestDTO todoRequestDTO) {
        return todoMapper.toTodoResponseWithoutSubDTO(todoRepository.save(todoMapper.toEntity(todoMapper.toTodoResponseWithoutSubDTO(todoMapper.toEntity(todoRequestDTO)))));
    }

    public SubTodoResponseWithParentDTO createSubToDo(final SubTodoRequestDTO subTodoRequestDTO) {
        return todoMapper.toSubTodoResponseWithParentDTO(subTodoRepository.save(todoMapper.toEntity(subTodoRequestDTO)));
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
        List<SubTodoResponseWithParentDTO> list = StreamSupport.stream(subTodoRepository.findAll().spliterator(), false)
                .map(todoMapper::toSubTodoResponseWithParentDTO)
                .toList();
        return list;
    }

    public void removeAllTodos() {
        todoRepository.deleteAll();
    }

    public void removeAllSubTodos() {
        List<SubTodoEntity> list = StreamSupport.stream(subTodoRepository.findAll().spliterator(), false).toList();
        for (SubTodoEntity subTodoEntity : list) {
            if (subTodoEntity.getParentTodoEntity() == null) {
                subTodoRepository.delete(subTodoEntity);
            }
        }
    }
}
