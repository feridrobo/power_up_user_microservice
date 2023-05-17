package com.pragma.powerup.usermicroservice.adapters.driving.http.controller;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IUserHandler;
import com.pragma.powerup.usermicroservice.configuration.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserRestControllerTest {

    @Mock
    private IUserHandler personHandler;

    @InjectMocks
    private UserRestController userRestController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void savePerson_shouldReturnCreatedResponse() {
        // Arrange
        UserRequestDto userRequestDto = new UserRequestDto("Jane",
                "Manuel", LocalDate.now().minusYears(19),
                "+573208853789",
                "1005036099",
                "feridrobo3@gmail.com",
                "Secret123#");

        // Act
        ResponseEntity<Map<String, String>> response = userRestController.savePerson(userRequestDto);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(Constants.PERSON_CREATED_MESSAGE, response.getBody().get(Constants.RESPONSE_MESSAGE_KEY));
        verify(personHandler).saveUser(userRequestDto);
    }

    @Test
    void saveOwner_shouldReturnCreatedResponse() {
        // Arrange
        UserRequestDto userRequestDto = new UserRequestDto("Jane",
                "Manuel", LocalDate.now().minusYears(19),
                "+573208853789",
                "1005036099",
                "feridrobo3@gmail.com",
                "Secret123#");

        // Act
        ResponseEntity<Map<String, String>> response = userRestController.saveOwner(userRequestDto);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(Constants.PERSON_CREATED_MESSAGE, response.getBody().get(Constants.RESPONSE_MESSAGE_KEY));
        verify(personHandler).saveOwner(userRequestDto);
    }
}
