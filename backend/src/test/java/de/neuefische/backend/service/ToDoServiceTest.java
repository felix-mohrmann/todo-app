package de.neuefische.backend.service;

import de.neuefische.backend.model.Status;
import de.neuefische.backend.model.ToDo;
import de.neuefische.backend.repository.ToDoRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ToDoServiceTest {

    @Test
    public void testRepoIsEmpty() {
        //given
        ToDoService toDoService = new ToDoService(new ToDoRepository());

        //when
        List<ToDo> actual = toDoService.getAllToDos();

        //then
        assertTrue(actual.isEmpty());
    }

    @Test
    public void testRepoReturnsAValue() {
        ToDoRepository toDotRepositoryMock = mock(ToDoRepository.class);
        when(toDotRepositoryMock.findAllToDos()).thenReturn(
                List.of(
                        new ToDo("description", Status.OPEN.name())
                )
        );
        ToDoService toDoService = new ToDoService(toDotRepositoryMock);

        //when
        List<ToDo> actual = toDoService.getAllToDos();

        //then
        assertFalse(actual.isEmpty());
    }

    @Test
    public void testNullToDoCreation() {
        //given
        ToDoService toDoService = new ToDoService(new ToDoRepository());

        try {
            //when
            ToDo todo = new ToDo("", Status.OPEN.name());
            toDoService.addNewToDo(todo);
            fail();
        } catch (IllegalArgumentException e) {
            //expected to be thrown if todo is null
        }
    }
}