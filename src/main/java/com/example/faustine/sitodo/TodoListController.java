package com.example.faustine.sitodo;

import com.example.faustine.sitodo.model.TodoItem;
import com.example.faustine.sitodo.repository.TodoListRepository;
import com.example.faustine.sitodo.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TodoListController {

    @Autowired
    private TodoListService todoListService;

    @Autowired
    public void setTodoListService(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @GetMapping("/list")
    public String showList(Model model) {
        List<TodoItem> todoItems = todoListService.getTodoItems();

        model.addAttribute("todoList", todoItems);

        return "list";
    }

    @PostMapping("/list")
    public String addTodoList(@RequestParam("item_text") String input) {
        todoListService.addTodoItem(new TodoItem(input));
        
        return "redirect:/list";
    }
}
