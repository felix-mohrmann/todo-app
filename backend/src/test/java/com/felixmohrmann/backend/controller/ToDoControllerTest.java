package com.felixmohrmann.backend.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.felixmohrmann.backend.model.ToDo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ToDoControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testGetAllToDos() {
        // Given
        String url = String.format("http://localhost:%d/api/todo", port);

        // When
        ResponseEntity<ToDo[]> actualResponse = testRestTemplate.getForEntity(url, ToDo[].class);

        // Then
        HttpStatus actualStatus = actualResponse.getStatusCode();
        assertEquals(HttpStatus.OK, actualStatus);
    }

    // exchange methode von exchange template verwenden um zu prüfen dass wir den
    // status geupdatet haben (?)
    // change todo status muss in controller rein
    // eine methode für todo controller

}