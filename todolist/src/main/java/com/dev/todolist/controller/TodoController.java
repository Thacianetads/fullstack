package com.dev.todolist.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.todolist.entity.Todo;
import com.dev.todolist.service.TodoService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tasks")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    List <Todo> create(@RequestBody Todo todo){
        return todoService.create(todo);
    }
    @GetMapping
    List <Todo> read(){
        return todoService.read();
    }

    @GetMapping("/{id}")
    public Todo getById(@PathVariable Long id) {
        return todoService.getById(id);
    }


    @PutMapping
    List <Todo> update(@RequestBody Todo todo){
        return todoService.update(todo);
    }
    @DeleteMapping("{id}")
    List <Todo> delete(@PathVariable Long id){
        return todoService.delete(id);
    }
    
}
