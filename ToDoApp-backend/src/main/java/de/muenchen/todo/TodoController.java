package de.muenchen.todo;

import de.muenchen.todo.dto.SubTodoRequestDTO;
import de.muenchen.todo.dto.TodoRequestDTO;
import de.muenchen.todo.dto.TodoResponseDTO;

import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TodoResponseDTO> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TodoResponseDTO getTodo(@PathVariable final UUID id) {
        return todoService.getTodo(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public UUID createTodo(@RequestBody final TodoRequestDTO todoRequestDTO) {
        if (todoRequestDTO.name().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return todoService.createTodo(todoRequestDTO);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public UUID createSubTodo(@RequestBody final SubTodoRequestDTO subTodoRequestDTO) {
        if(subTodoRequestDTO.name().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return  todoService.createSubToDo(subTodoRequestDTO);
    }
}
