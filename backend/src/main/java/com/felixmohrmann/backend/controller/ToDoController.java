package com.felixmohrmann.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.felixmohrmann.backend.model.ToDo;
import com.felixmohrmann.backend.service.ToDoService;

import java.util.List;

@RestController
@RequestMapping("api/todo")
public class ToDoController {

    ToDoService todoService;

    @Autowired
    public ToDoController(ToDoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<ToDo> getAllToDos() {
        return todoService.getAllToDos();
    }

    @PostMapping
    public ToDo addNewTodo(@RequestBody ToDo toDo) {
        return todoService.addNewToDo(toDo);
    }

    @PutMapping("{id}")
    public ToDo changeToDoStatus(@PathVariable("id") String id) {
        return todoService.advanceStatus(id);
    }

    @DeleteMapping("{id}")
    public void deleteToDo(@PathVariable("id") String id) {
        todoService.deleteToDo(id);
    }
}