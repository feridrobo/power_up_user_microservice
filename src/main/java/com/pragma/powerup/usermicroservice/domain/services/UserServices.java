package com.pragma.powerup.usermicroservice.domain.services;

import com.pragma.powerup.usermicroservice.domain.exceptions.UnderAgeException;

import java.time.LocalDate;
import java.time.Period;

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



}
