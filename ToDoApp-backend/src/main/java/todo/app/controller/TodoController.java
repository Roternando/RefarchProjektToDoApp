package todo.app.controller;

import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import todo.app.common.dto.TodoDTO;
import todo.app.service.TodoService;

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
    public TodoDTO getTodo(@PathVariable UUID id){
        return todoService.getTodo(id);
    }
}
