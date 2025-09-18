package de.muenchen.todo;

import de.muenchen.todo.dto.SubTodoRequestDTO;
import de.muenchen.todo.dto.SubTodoResponseWithParentDTO;
import de.muenchen.todo.dto.TodoRequestDTO;
import de.muenchen.todo.dto.TodoResponseWithSubDTO;
import de.muenchen.todo.dto.TodoResponseWithoutSubDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/createWithSub")
    @ResponseStatus(HttpStatus.OK)
    public TodoResponseWithSubDTO createTodoWithSubTodo(@RequestBody final TodoRequestDTO todoRequestDTO) {
        if (todoRequestDTO.name().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return todoService.createTodoWithSubTodo(todoRequestDTO);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public TodoResponseWithoutSubDTO createTodoWithoutSubTodo(@RequestBody final TodoRequestDTO todoRequestDTO) {
        if (todoRequestDTO.name().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return todoService.createTodoWithoutSubTodo(todoRequestDTO);
    }

    @PostMapping("/sub/create")
    @ResponseStatus(HttpStatus.OK)
    public SubTodoResponseWithParentDTO createSubTodo(@RequestBody final SubTodoRequestDTO subTodoRequestDTO) {
        if (subTodoRequestDTO.name().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return todoService.createSubToDo(subTodoRequestDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TodoResponseWithSubDTO getTodo(@PathVariable final UUID id) {
        return todoService.getTodo(id);
    }

    @GetMapping("/sub/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SubTodoResponseWithParentDTO getSubTodo(@PathVariable final UUID id) {
        return todoService.getSubTodo(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TodoResponseWithSubDTO> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/sub")
    @ResponseStatus(HttpStatus.OK)
    public List<SubTodoResponseWithParentDTO> getAllSubTodos() {
        return todoService.getAllSubTodos();
    }

    @DeleteMapping("/remove")
    @ResponseStatus(HttpStatus.OK)
    public void removeAllTodos() {
        todoService.removeAllTodos();
    }

    @DeleteMapping("/sub/remove")
    @ResponseStatus(HttpStatus.OK)
    public void removeAllSubTodos() {
        todoService.removeAllSubTodos();
    }
}
