package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import com.pragma.powerup.usermicroservice.configuration.Constants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class UserRequestDto {

    @NotEmpty(message = Constants.NAME_NOT_BLANK_MESSAGE)
    @Schema(description = "Name", example = "Manuel")
    private String name;

    @NotEmpty(message = Constants.SURNAME_NOT_BLANK_MESSAGE)
    @Schema(description = "Surname", example = "Idrobo")
    private String surname;

    @NotNull(message = Constants.BIRTHDATE_NOT_NULL_MESSAGE)
    @Past(message = Constants.BIRTHDATE_PAST_MESSAGE)
    @Schema(description = "Date of Birth", example = "2001-10-30")
    private LocalDate birthdate;

    @NotEmpty(message = Constants.PHONE_NOT_BLANK_MESSAGE)
    @Pattern(regexp = "^\\+?[0-9]{1,13}$", message = Constants.PHONE_PATTERN_MESSAGE)
    @Schema(description = "Cellphone Number", example = "+573208853789")
    private String phone;

    @NotEmpty(message = Constants.DNI_NUMBER_NOT_BLANK_MESSAGE)
    @Pattern(regexp = "^\\d{6,11}$", message = Constants.DNI_NUMBER_DIGITS_MESSAGE)
    @Size(min = 6, max = 11, message = Constants.DNI_NUMBER_SIZE_MESSAGE)
    @Schema(description = "Identification Document Number", example = "1234567890")
    private String dniNumber;

    @NotEmpty(message = Constants.EMAIL_NOT_BLANK_MESSAGE)
    @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = Constants.EMAIL_FORMAT_MESSAGE)
    @Schema(description = "Email", example = "feridrobo3@gmail.com")
    private String mail;

    @NotEmpty(message = Constants.PASSWORD_NOT_BLANK_MESSAGE)
    @Size(min = 9, message = Constants.PASSWORD_SIZE_MESSAGE)
    @Schema(description = "Password", example = "Secret30#")
    private String password;


}
