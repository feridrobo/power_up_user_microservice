package com.pragma.powerup.usermicroservice.domain.exceptions;

public class UnderAgeException extends RuntimeException {
    public UnderAgeException() {
        super("The user is under the minimum age requirement.");
    }
}
