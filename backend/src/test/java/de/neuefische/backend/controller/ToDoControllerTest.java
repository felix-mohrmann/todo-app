package de.neuefische.backend.controller;

import de.neuefische.backend.model.ToDo;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ToDoControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void testGetAllToDos(){
        //Given
        String url = "http://localhost:" + port + "api/todo";

        //When
        ResponseEntity<ToDo[]> actualResponse = testRestTemplate.getForEntity(url, ToDo[].class);
        HttpStatus expectedStatus = HttpStatus.OK;

        //Then
        assertEquals(expectedStatus, actualResponse.getStatusCode());
    }


}