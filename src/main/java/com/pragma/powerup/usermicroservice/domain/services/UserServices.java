package com.pragma.powerup.usermicroservice.domain.services;

import com.pragma.powerup.usermicroservice.domain.exceptions.UnderAgeException;
import com.pragma.powerup.usermicroservice.domain.model.Role;
import com.pragma.powerup.usermicroservice.domain.model.User;

import java.time.LocalDate;
import java.time.Period;

import static com.pragma.powerup.usermicroservice.configuration.Constants.OWNER_ROLE_ID;

public class UserServices {

    private static final int minimumAge = 18;

    public static void validateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        int age = calculateAge(birthDate, currentDate);

        if (age < minimumAge) {
            throw new UnderAgeException();
        }
    }

    private static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        return Period.between(birthDate, currentDate).getYears();
    }

    public static void  validateRoleOwner(User user) {
        Role role = user.getRole();
        if (role.getId() != OWNER_ROLE_ID) {
            throw new UnderAgeException();
        }
    }




}
