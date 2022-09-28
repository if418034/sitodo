package com.example.faustine.sitodo.service;

import com.example.faustine.sitodo.model.TodoItem;
import com.example.faustine.sitodo.repository.TodoListRepository;
import com.example.faustine.sitodo.service.TodoListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class TodoListServiceTest {

    @Autowired
    private TodoListService todoListService;

    @MockBean
    private TodoListRepository todoListRepository;

    @Test
    void getTodoItems_someItems_ok() {
        when(todoListRepository.findAll()).thenReturn(List.of(
            new TodoItem("A"),
            new TodoItem("B"),
            new TodoItem("C")
        ));

        List<TodoItem> todoItems = todoListService.getTodoItems();

        assertEquals(3, todoItems.size());
    }

    @Test
    void addTodoItem_ok() {
        TodoItem todoItem = new TodoItem("Buy milk");
        when(todoListRepository.save(any(TodoItem.class))).thenReturn(todoItem);

        TodoItem savedTodoItem = todoListService.addTodoItem(todoItem);

        assertEquals("Buy milk", savedTodoItem.getTitle());
    }
}