package com.codegym.dto;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.employee.Division;
import com.codegym.model.entity.employee.EducationDegree;
import com.codegym.model.entity.employee.PositionEmpl;
import lombok.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto implements Validator {
    private Integer employeeId;

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Please capitalize the first letter of each word!")
    private String employeeName;

    private String employeeBirthday;

    @NotEmpty
    @Pattern(regexp = "^([0-9]{9}|[0-9]{12})$",
            message = "Please re-enter in the format: XXXXXXXXX or XXXXXXXXXXXX (X: 0-9)")
    private String employeeIdCard;

    @NotNull
    @Min(1)
    private Integer employeeSalary;

    @NotEmpty
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$",
            message = "Please re-enter in the format: 090xxxxxxx or 091xxxxxxx " +
                    "or (84)+90xxxxxxx or (84)+91xxxxxxx (x: 0-9)")
    private String employeePhone;

    @NotBlank
    @Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$",
            message = "Please re-enter in the format: abc@gmail.com or abc@gmail.com.vn")
    private String employeeEmail;

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Please capitalize the first letter of each word!")
    private String employeeAddress;

    private PositionEmpl positionEmpl;
    private EducationDegree educationDegree;
    private Division division;
    private Set<Contract> contract;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @SneakyThrows
    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        String stringDate = employeeDto.getEmployeeBirthday();

        if (stringDate.equals("")) {
            errors.rejectValue("employeeBirthday", "employeeBirthday.notBlank");
            return;
        }

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
        java.sql.Date dateNow = new java.sql.Date(System.currentTimeMillis());

        if (date.compareTo(dateNow) > 0) {
            errors.rejectValue("employeeBirthday", "employeeBirthday.futureDay");
        }

        if (date.compareTo(dateNow) == 0) {
            errors.rejectValue("employeeBirthday", "employeeBirthday.nowDay");
        }
    }
}
