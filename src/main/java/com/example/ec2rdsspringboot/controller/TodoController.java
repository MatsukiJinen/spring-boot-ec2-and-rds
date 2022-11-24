package com.example.ec2rdsspringboot.controller;

import com.example.ec2rdsspringboot.entity.Todo;
import com.example.ec2rdsspringboot.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService service;

    @GetMapping
    public ResponseEntity<List<Todo>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable int id) {
        return ResponseEntity.ok(service.getTodoById(id));
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodoItem) {
        Todo saveTodoItem = service.saveTodo(newTodoItem);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveTodoItem.getId()).toUri();
        return ResponseEntity.created(location).body(newTodoItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo updateTodo, @PathVariable int id) {
        service.updateTodo(updateTodo, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Todo> deleteTodo(@PathVariable int id) {
        service.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
}
