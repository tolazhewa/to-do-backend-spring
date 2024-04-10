package com.tolazhewa.todobackendspring.controllers;

import com.tolazhewa.todobackendspring.models.Todo;
import com.tolazhewa.todobackendspring.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/api")
public class TodoController {
    private static final long MIN_SAFE_INTEGER = -9007199254740991L;
    private static final long MAX_SAFE_INTEGER = 9007199254740991L;

    private final TodoService todoService;
    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @DeleteMapping({"/todos/{todoId}/", "/todos/{todoId}"})
    public ResponseEntity<Void> deleteTodo(@PathVariable Long todoId) {
        boolean removed = todoService.removeTodo(todoId);
        if (removed) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping({"/todos/{todoId}", "/todos/{todoId}"})
    public ResponseEntity<Todo> getTodo(@PathVariable Long todoId) {
        Optional<Todo> todo = todoService.getTodo(todoId);
        return todo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping({"/todos", "/todos/"})
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Long id = ThreadLocalRandom.current().nextLong(MIN_SAFE_INTEGER, MAX_SAFE_INTEGER + 1);
        // TODO: ENSURE ID is not in DB
        todo.setId(id);
        Todo savedTodo = todoService.save(todo);
        return ResponseEntity.ok(savedTodo);
    }

    @GetMapping({"/todos/user/{userId}", "/todos/user/{userId}/"})
    public ResponseEntity<List<Todo>> getTodosForUser(@PathVariable Long userId) {
        List<Todo> todos = todoService.getTodosForUser(userId);
        return ResponseEntity.ok(todos);
    }

    @GetMapping({"/todos", "/todos/"})
    public ResponseEntity<List<Todo>> getTodos() {
        return ResponseEntity.ok(todoService.getTodos());

    }
}
