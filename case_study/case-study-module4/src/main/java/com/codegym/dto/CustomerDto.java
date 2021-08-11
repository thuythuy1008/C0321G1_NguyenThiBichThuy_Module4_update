package com.codegym.dto;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.customer.CustomerType;
import lombok.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto implements Validator {
    private Integer customerId;

    @NotEmpty
    @Pattern(regexp = "^(KH)-[0-9]{4}$", message = "Please re-enter in the format : KH-XXXX (X: 0-9)")
    private String customerCode;

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Please capitalize the first letter of each word!")
    private String customerName;

    private String customerBirthday;
    private Integer customerGender;

    @NotEmpty
    @Pattern(regexp = "^([0-9]{9}|[0-9]{12})$",
            message = "Please re-enter in the format: XXXXXXXXX or XXXXXXXXXXXX (X: 0-9)")
    private String customerIdCard;

    @NotEmpty
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$",
            message = "Please re-enter in the format: 090xxxxxxx or 091xxxxxxx " +
                    "or (84)+90xxxxxxx or (84)+91xxxxxxx (x: 0-9)")
    private String customerPhone;

    @NotBlank
    @Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$",
            message = "Please re-enter in the format: abc@gmail.com or abc@gmail.com.vn")
    private String customerEmail;

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Please capitalize the first letter of each word!")
    private String customerAddress;

    private CustomerType customerType;
    private Set<Contract> contract;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @SneakyThrows
    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        String stringDate = customerDto.getCustomerBirthday();

        if (stringDate.equals("")) {
            errors.rejectValue("customerBirthday", "customerBirthday.notBlank");
            return;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(stringDate, formatter);
        LocalDate dateNow = LocalDate.now();

        int age = Period.between(date, dateNow).getYears();

        if (date.compareTo(dateNow) > 0) {
            errors.rejectValue("customerBirthday", "customerBirthday.futureDay");
        }

        if (date.compareTo(dateNow) == 0) {
            errors.rejectValue("customerBirthday", "customerBirthday.nowDay");
        }

        if (age < 18) {
            errors.rejectValue("customerBirthday", "customerBirthday.age");
        }
    }
}
