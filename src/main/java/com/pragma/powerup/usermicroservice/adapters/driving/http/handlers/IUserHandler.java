package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;

public interface IUserHandler {
    void saveUser(UserRequestDto personRequestDto);
    void saveOwner(UserRequestDto personRequestDto);
    RoleEntity  getRoleByUserId(Long id);
    UserEntity getUserById(Long id);



}
