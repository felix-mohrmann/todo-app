package com.felixmohrmann.backend.service;

import org.junit.jupiter.api.Test;

import com.felixmohrmann.backend.model.Status;
import com.felixmohrmann.backend.model.ToDo;
import com.felixmohrmann.backend.repository.ToDoRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ToDoServiceTest {

    @Test
    public void testRepoIsEmpty() {
        // given
        ToDoService toDoService = new ToDoService(new ToDoRepository());

        // when
        List<ToDo> actual = toDoService.getAllToDos();

        // then
        assertTrue(actual.isEmpty());
    }

    @Test
    public void testRepoReturnsAValue() {
        ToDoRepository toDotRepositoryMock = mock(ToDoRepository.class);
        when(toDotRepositoryMock.findAllToDos()).thenReturn(
                List.of(
                        new ToDo("description", Status.OPEN.name())));
        ToDoService toDoService = new ToDoService(toDotRepositoryMock);

        // when
        List<ToDo> actual = toDoService.getAllToDos();

        // then
        assertFalse(actual.isEmpty());
    }

    @Test
    public void testNullToDoCreation() {
        // given
        ToDoService toDoService = new ToDoService(new ToDoRepository());

        try {
            // when
            ToDo todo = new ToDo("", Status.OPEN.name());
            toDoService.addNewToDo(todo);
            fail();
        } catch (IllegalArgumentException e) {
            // expected to be thrown if todo is null
        }
    }
}