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

    public String addNewToDo(String description) {
        return toDoRepository.addNewToDo(description);
    }
}
