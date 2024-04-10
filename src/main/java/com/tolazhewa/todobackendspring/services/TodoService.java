package com.tolazhewa.todobackendspring.services;

import com.tolazhewa.todobackendspring.models.Todo;
import com.tolazhewa.todobackendspring.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    final private TodoRepository repository;

    @Autowired
    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public Todo save(Todo todo) {
        return repository.save(todo);
    }

    public List<Todo> getTodosForUser(Long userId) {
        return repository.findByUserId(userId);
    }
    public List<Todo> getTodos() {
        return repository.findAll();
    }

    public boolean removeTodo(Long todoId) {
        try {
            repository.deleteById(todoId);
            return true;
        } catch (EmptyResultDataAccessException e){
            return false;
        }
    }

    public Optional<Todo> getTodo(Long todoId) {
        return repository.findById(todoId);
    }
}
