package com.example.ec2rdsspringboot.service;

import com.example.ec2rdsspringboot.entity.Todo;
import com.example.ec2rdsspringboot.repository.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TodoServiceTest {

    @Autowired
    private TodoService todoService;

    @MockBean
    private TodoRepository todoRepository;

    @BeforeEach
    void setUp() {
        Todo todo = Todo.builder().id(1).title("test").description("test").build();
        Mockito.when(todoRepository.findByTitleIgnoreCase("test")).thenReturn(todo);
    }

    @Test
    public void whenValidTitle() {
        String title = "test";
        Todo todo = todoService.getTodoByTitle(title);
        assertEquals(title, todo.getTitle());
    }
}