package de.neuefische.backend.service;

import de.neuefische.backend.model.Status;
import de.neuefische.backend.model.ToDo;
import de.neuefische.backend.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.notNull;

@Service
public class ToDoService {

    ToDoRepository toDoRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> getAllToDos() {
        return toDoRepository.findAllToDos();
    }

    public ToDo addNewToDo(ToDo toDo) {
        //check if all requirements are met
        notNull(toDo, "Todo must not be null to be created");
        hasText(toDo.getDescription(), "Todo must have a valid description to be created");

        //set user input to "creation default status OPEN
        toDo.setStatus(Status.OPEN.name());

        return toDoRepository.addNewToDo(toDo);
    }

    public ToDo getToDoByID(String id) {
        return toDoRepository.getToDoById(id);
    }

    public ToDo advanceStatus(String id) {
        ToDo toDo = getToDoByID(id);
        switch (toDo.getStatus()) {
            case "OPEN" -> toDo.setStatus("IN_PROGRESS");
            case "IN_PROGRESS" -> toDo.setStatus("DONE");
        }

        return toDo;
    }

    public void deleteToDo(String id) {
        toDoRepository.deleteToDo(id);
    }
}