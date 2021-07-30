package de.neuefische.backend.service;

import de.neuefische.backend.model.ToDo;
import de.neuefische.backend.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    ToDoRepository toDoRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> getAllToDos() {
        return toDoRepository.getAllToDos();
    }

    public ToDo addNewToDo(ToDo toDo) {
        return toDoRepository.addNewToDo(toDo);
    }

    public ToDo getToDoByID(String id) {
        return toDoRepository.getToDoById(id);
    }

    public ToDo advanceStatus(String id) {
        ToDo toDo =getToDoByID(id);
        switch(toDo.getStatus()) {
            case "OPEN": toDo.setStatus("IN_PROGRESS"); break;
            case "IN_PROGRESS": toDo.setStatus("DONE"); break;
        }

        return toDo;

    }
}
