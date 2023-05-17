package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IRoleRepository;
import com.pragma.powerup.usermicroservice.domain.exceptions.UnderAgeException;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserUseCaseTest {

    @Mock
    private IUserPersistencePort userPersistencePort;

    private UserUseCase userUseCase;
    private  IRoleRepository roleRepository;


    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        userUseCase = new UserUseCase(userPersistencePort, roleRepository);
    }

    @Test
    void testSaveUser_ThrowsUserUnderAgeException() {
        User user = new User(null, null, null, LocalDate.now().minusYears(19), null, null, null ,null, null);

        assertThrows(UnderAgeException.class, () -> userUseCase.saveUser(user));
    }

    @Test
    void testSaveOwner_ThrowsUserUnderAgeException() {
        User user = new User(null, null, null, LocalDate.now().minusYears(19), null, null, null ,null, null);

        assertThrows(UnderAgeException.class, () -> userUseCase.saveOwner(user));
    }

    @Test
    void testSaveUser_Successful() {
        User user = new User(null, null, null, LocalDate.now().minusYears(19), null, null, null, null, null);

        userUseCase.saveUser(user);

        verify(userPersistencePort, times(1)).saveUser(user);
    }

    @Test
    void testSaveOwner_Successful() {
        User user = new User(null, null, null, LocalDate.now().minusYears(19), null, null, null, null, null);

        userUseCase.saveOwner(user);

        verify(userPersistencePort, times(1)).saveUser(user);
    }
}
