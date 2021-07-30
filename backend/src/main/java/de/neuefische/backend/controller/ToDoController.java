package de.neuefische.backend.controller;

import de.neuefische.backend.model.ToDo;
import de.neuefische.backend.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        //return List.of( new ToDo("description","OPEN"));
        return todoService.getAllToDos();
    }

    @GetMapping
    public ToDo getToDoById() {
        //Erzeuge eine ToDo. Vergleiche die Id des ToDos mit einer übergebenen Id.
        return null;
    }

    @PostMapping
    public String addNewTodo(@RequestBody String description) {

        todoService.addNewToDo(description);
        return "hi";
    }
}
