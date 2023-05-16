package com.pragma.powerup.usermicroservice.configuration;

public class Constants {



    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final Long CLIENT_ROLE_ID = 1L;
    public static final Long EMPLOYEE_ROLE_ID = 2L;
    public static final Long PROVIDER_ROLE_ID = 3L;
    public static final int MAX_PAGE_SIZE = 2;
    public static final String RESPONSE_MESSAGE_KEY = "message";
    public static final String PERSON_CREATED_MESSAGE = "Person created successfully";
    public static final String USER_CREATED_MESSAGE = "User created successfully";
    public static final String USER_DELETED_MESSAGE = "User deleted successfully";
    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error";
    public static final String WRONG_CREDENTIALS_MESSAGE = "Wrong credentials or role not allowed";
    public static final String NO_DATA_FOUND_MESSAGE = "No data found for the requested petition";
    public static final String PERSON_ALREADY_EXISTS_MESSAGE = "A person already exists with the DNI number provided";
    public static final String MAIL_ALREADY_EXISTS_MESSAGE = "A person with that mail already exists";
    public static final String PERSON_NOT_FOUND_MESSAGE = "No person found with the id provided";
    public static final String ROLE_NOT_FOUND_MESSAGE = "No role found with the id provided";
    public static final String ROLE_NOT_ALLOWED_MESSAGE = "No permission granted to create users with this role";
    public static final String USER_ALREADY_EXISTS_MESSAGE = "A user already exists with the role provided";
    public static final String USER_NOT_FOUND_MESSAGE = "No user found with the role provided";
    public static final String SWAGGER_TITLE_MESSAGE = "User API Pragma Power Up";
    public static final String SWAGGER_DESCRIPTION_MESSAGE = "User microservice";
    public static final String SWAGGER_VERSION_MESSAGE = "1.0.0";
    public static final String SWAGGER_LICENSE_NAME_MESSAGE = "Apache 2.0";
    public static final String SWAGGER_LICENSE_URL_MESSAGE = "http://springdoc.org";
    public static final String SWAGGER_TERMS_OF_SERVICE_MESSAGE = "http://swagger.io/terms/";

    public static final String NAME_NOT_BLANK_MESSAGE = "Name cannot be null or empty";
    public static final String SURNAME_NOT_BLANK_MESSAGE = "Surname cannot be null or empty";
    public static final String DNI_NUMBER_NOT_BLANK_MESSAGE = "Document number cannot be null or empty";
    public static final String DNI_NUMBER_DIGITS_MESSAGE = "Document number must contain numeric values";
    public static final String DNI_NUMBER_SIZE_MESSAGE = "Document number must be between 6 and 11 characters long";
    public static final String PHONE_NOT_BLANK_MESSAGE = "Phone number cannot be null or empty";
    public static final String PHONE_PATTERN_MESSAGE = "Phone number must have a maximum of 13 characters and may contain the '+' symbol";
    public static final String BIRTHDATE_NOT_NULL_MESSAGE = "Birthdate cannot be null";
    public static final String BIRTHDATE_PAST_MESSAGE = "Birthdate must be a date prior to the current date";
    public static final String EMAIL_NOT_BLANK_MESSAGE = "Email cannot be null or empty";
    public static final String EMAIL_FORMAT_MESSAGE = "Must be a valid email address";
    public static final String PASSWORD_NOT_BLANK_MESSAGE = "Password cannot be null or empty";
    public static final String PASSWORD_SIZE_MESSAGE = "Password must contain more than 8 characters";

}
