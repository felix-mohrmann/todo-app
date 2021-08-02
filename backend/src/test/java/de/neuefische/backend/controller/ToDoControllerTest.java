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
    private TestRestTemplate testRestTemplate;

    @Test
    public void testGetAllToDos(){
        //Given
        String url = String.format("http://localhost:%d/api/todo", port);

        //When
        ResponseEntity<ToDo[]> actualResponse = testRestTemplate.getForEntity(url, ToDo[].class);

        //Then
        HttpStatus actualStatus = actualResponse.getStatusCode();
        assertEquals(HttpStatus.OK, actualStatus);

        ToDo[] actualResponseBody = actualResponse.getBody();
        assertEquals(0, actualResponseBody.length);
    }
}