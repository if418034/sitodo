package com.example.faustine.sitodo.service;

import com.example.faustine.sitodo.model.TodoItem;
import com.example.faustine.sitodo.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService {

    private TodoListRepository todoListRepository;

    @Autowired
    public void setTodoListRepository(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    public TodoItem addTodoItem(TodoItem todoItem) {
        return todoListRepository.save(todoItem);
    }

    public List<TodoItem> getTodoItems() {
        return (List<TodoItem>) todoListRepository.findAll();
    }
}
