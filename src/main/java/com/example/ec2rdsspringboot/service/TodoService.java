package com.example.ec2rdsspringboot.service;


import com.example.ec2rdsspringboot.entity.Todo;

import java.util.List;

public interface TodoService {
    public List<Todo> getAll();
    public Todo getTodoById(int id);
    Todo getTodoByTitle(String title);
    public Todo saveTodo(Todo todo);
    public void updateTodo(Todo todo, int id);
    public void deleteTodo(int id);
}
