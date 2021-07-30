package de.neuefische.backend.repository;

import de.neuefische.backend.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ToDoRepository {

    private List<ToDo> toDoList = new ArrayList<>();

    @Autowired
    public ToDoRepository(List<ToDo> toDoList) {
        this.toDoList = toDoList;
    }

    public List<ToDo> getAllToDos() {
        return toDoList;
    }

    public ToDo addNewToDo(ToDo toDo) {
        toDoList.add(toDo);
        return toDo;
    }
}
