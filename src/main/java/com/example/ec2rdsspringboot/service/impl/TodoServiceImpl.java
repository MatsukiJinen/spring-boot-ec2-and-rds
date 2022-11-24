package com.example.ec2rdsspringboot.service.impl;

import com.example.ec2rdsspringboot.entity.Todo;
import com.example.ec2rdsspringboot.error.TodoNotFoundException;
import com.example.ec2rdsspringboot.repository.TodoRepository;
import com.example.ec2rdsspringboot.service.TodoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository repository;

    public TodoServiceImpl(TodoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Todo> getAll() {
        return repository.findAll();
    }

    @Override
    public Todo getTodo(int id) throws TodoNotFoundException{
        return findTodoById(id);
    }

    @Override
    public Todo saveTodo(Todo todo) {
        return repository.save(todo);
    }

    @Override
    public void updateTodo(Todo todo, int id) {
        Todo updateTodo = findTodoById(id);
        updateTodo.setTitle(todo.getTitle());
        updateTodo.setDescription(todo.getDescription());
        repository.save(updateTodo);
    }

    @Override
    public void deleteTodo(int id) {
        repository.deleteById(id);
    }

    private Todo findTodoById(int id) {
        Optional<Todo> todo = repository.findById(id);
        if (!todo.isPresent()) {
            throw new TodoNotFoundException("Item Not found Id: " + id);
        }
        return todo.get();
    }
}
