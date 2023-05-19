package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.UserNotFoundException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IUserRepository;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IUserHandler;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IUserRequestMapper;
import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;

import com.pragma.powerup.usermicroservice.domain.spi.IRolePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserHandlerImpl implements IUserHandler {
    private final IUserServicePort personServicePort;
    private final IUserRequestMapper personRequestMapper;
    private final IUserRepository userRepository;
    private final IRolePersistencePort rolePersistencePort;


    @Override
    public void saveUser(UserRequestDto userRequestDto) {
        personServicePort.saveUser(personRequestMapper.toUser(userRequestDto));
    }

    @Override
    public void saveOwner(UserRequestDto userRequestDto) {
        personServicePort.saveOwner(personRequestMapper.toUser(userRequestDto));
    }

    @Override
    public RoleEntity  getRoleByUserId(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);

        Long roleId = userEntity.getRole().getId();


        RoleEntity roleEntity = rolePersistencePort.getRoleById(roleId);



        return roleEntity;
    }

    @Override
    public UserEntity getUserById(Long id) {
        UserEntity userEntity = userRepository.findUserById(id).orElseThrow(UserNotFoundException::new);
        return userEntity;
    }

}
