package de.neuefische.backend.repository;

import de.neuefische.backend.model.Status;
import de.neuefische.backend.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ToDoRepository {

    List<ToDo> toDoList = List.of(
            new ToDo("description")
    );

    @Autowired
    public ToDoRepository(List<ToDo> toDoList) {
        this.toDoList = toDoList;
    }


    public List<ToDo> getAllToDos() {
        return toDoList;
    }


    public String addNewToDo(String description) {
        ToDo toDo = new ToDo(description);
        toDoList.add(toDo);
        return toDo.getDescription();
    }
}
