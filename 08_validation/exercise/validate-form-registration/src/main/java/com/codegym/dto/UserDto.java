package com.codegym.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
public class UserDto implements Validator {
    private Integer id;

    @NotEmpty
    @NotBlank
    @Size(min = 5, max = 45)
    private String firstName;

    @NotEmpty
    @NotBlank
    @Size(min = 5, max = 45)
    private String lastName;

    private String phoneNumber;

    @Min(18)
    private Integer age;

    @Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$",
            message = "please enter correct email format")
    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        String number = userDto.getPhoneNumber();
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "number.empty");
        if (number.length() > 11 || number.length() < 10) {
            errors.rejectValue("phoneNumber", "number.length");
        }
        if (!number.startsWith("0")) {
            errors.rejectValue("phoneNumber", "number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("phoneNumber", "number.matches");
        }
    }
}
