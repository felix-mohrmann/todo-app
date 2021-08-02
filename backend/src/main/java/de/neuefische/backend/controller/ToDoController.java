package de.neuefische.backend.controller;

import de.neuefische.backend.model.ToDo;
import de.neuefische.backend.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ToDo changeToDoStatus(@PathVariable (name= "id") String id){
        return todoService.advanceStatus(id);
    }


    @DeleteMapping("{id}")
    public void deleteToDo(@PathVariable (name = "id") String id){
         todoService.deleteToDo(id);
    }
}