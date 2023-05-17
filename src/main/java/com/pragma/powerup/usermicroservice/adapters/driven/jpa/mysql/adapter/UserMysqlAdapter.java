package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.MailAlreadyExistsException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.PersonAlreadyExistsException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.UserAlreadyExistsException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IUserEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IRoleRepository;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IUserRepository;
import com.pragma.powerup.usermicroservice.domain.model.Role;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class UserMysqlAdapter implements IUserPersistencePort {
    private final IUserRepository userRepository;
    private final IUserEntityMapper personEntityMapper;
    private final PasswordEncoder passwordEncoder;
    private final IRoleRepository roleRepository;
    @Override
    public void saveUser(User user) {
        if (userRepository.existsByDniNumber(user.getDniNumber())) {
            throw new UserAlreadyExistsException();
        }
        if (userRepository.findByDniNumber(user.getDniNumber()).isPresent()) {
            throw new PersonAlreadyExistsException();
        }

        if (userRepository.existsByMail(user.getMail())){
            throw new MailAlreadyExistsException();
        }
        //assignRoleAdmin(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(personEntityMapper.toEntity(user));
    }
/*
    public void assignRoleAdmin(User user) {
        RoleEntity ownerRole = roleRepository.getById(1L);
        if (ownerRole == null) {
            throw new IllegalStateException("Role 'OWNER' does not exist in the database.");
        }
        Role role = mapRole(ownerRole);
        user.setRole(role);
    }

   public void assignRoleOwner(User user) {
        RoleEntity ownerRole = roleRepository.getById(2L);
        if (ownerRole == null) {
            throw new IllegalStateException("Role 'OWNER' does not exist in the database.");
        }
        Role role = mapRole(ownerRole);
        user.setRole(role);
    }

    private Role mapRole(RoleEntity roleEntity) {
        return new Role(roleEntity.getId(),
                        roleEntity.getName(),
                        roleEntity.getDescription());
    } */



}
