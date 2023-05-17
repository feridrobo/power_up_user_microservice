package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IRoleRepository;
import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import com.pragma.powerup.usermicroservice.domain.model.Role;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.services.UserServices;
import com.pragma.powerup.usermicroservice.domain.spi.IRolePersistencePort;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter.RoleMysqlAdapter;


import static com.pragma.powerup.usermicroservice.configuration.Constants.ADMIN_ROLE_ID;
import static com.pragma.powerup.usermicroservice.configuration.Constants.OWNER_ROLE_ID;

public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;
    private final IRoleRepository roleRepository;




    public UserUseCase(IUserPersistencePort personPersistencePort,
                       IRoleRepository roleRepository) {
        this.userPersistencePort = personPersistencePort;
        this.roleRepository = roleRepository;

    }

    @Override
    public void saveUser(User user) {
        UserServices.validateAge(user.getBirthdate());
        Role role = new Role(ADMIN_ROLE_ID, "ROLE_ADMIN", "ROLE_ADMIN");
        user.setRole(role);
        userPersistencePort.saveUser(user);
    }
    @Override
    public void saveOwner(User user) {
        UserServices.validateAge(user.getBirthdate());
        Role role = new Role(OWNER_ROLE_ID, "ROLE_OWNER", "ROLE_OWNER");
        user.setRole(role);
        userPersistencePort.saveUser(user);
    }


}
