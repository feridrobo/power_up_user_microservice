package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.pragma.powerup.usermicroservice.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserEntityMapper {
    UserEntity toEntity(User user);

    @Mapping(target = "id", source = "userEntity.id")
    @Mapping(target = "name", source = "userEntity.name")
    @Mapping(target = "surname", source = "userEntity.surname")
    @Mapping(target = "mail", source = "userEntity.mail")
    @Mapping(target = "phone", source = "userEntity.phone")
    @Mapping(target = "birthdate", source = "userEntity.birthdate")
    @Mapping(target = "dniNumber", source = "userEntity.dniNumber")
    @Mapping(target = "password", source = "userEntity.password")
    @Mapping(target = "role.id", source = "userEntity.role.id")
    User toUser(UserEntity userEntity);
}
