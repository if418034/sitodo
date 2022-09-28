package com.example.faustine.sitodo.repository;

import com.example.faustine.sitodo.model.TodoItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends CrudRepository<TodoItem, Long> {
}
