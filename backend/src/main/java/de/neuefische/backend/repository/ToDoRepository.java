package de.neuefische.backend.repository;

import de.neuefische.backend.model.ToDo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ToDoRepository {

    private List<ToDo> toDoList = new ArrayList<>();

    public List<ToDo> findAllToDos() {
        return toDoList;
    }

    public ToDo addNewToDo(ToDo toDo) {
        toDoList.add(toDo);
        return toDo;
    }

    public ToDo getToDoById(String id) {
        for (ToDo toDo : toDoList) {
            if (toDo.getId().equals(id)) {
                return toDo;
            }
        }
        return null;
    }

    public void deleteToDo(String id) {
        toDoList.remove(getToDoById(id));
    }
}