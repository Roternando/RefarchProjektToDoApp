package de.muenchen.todo;

import de.muenchen.todo.dto.CreateTodoDTO;
import de.muenchen.todo.dto.TodoDTO;
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
    public List<TodoDTO> getAllTodos() {
        // Bla bla Validierung
        // if(blöd gelaufen)
        // throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TodoDTO getTodo(@PathVariable final UUID id) {
        return todoService.getTodo(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public UUID createTodo(@RequestBody final CreateTodoDTO createTodoDTO) {
        if (createTodoDTO.name().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return todoService.createTodo(createTodoDTO);
    }
}
