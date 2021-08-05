package com.codegym.dto;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.employee.Division;
import com.codegym.model.entity.employee.EducationDegree;
import com.codegym.model.entity.employee.PositionEmpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Integer employeeId;

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Vui lòng viết hoa chữ cái đầu tiên của mỗi từ!")
    private String employeeName;

    private String employeeBirthday;

    @NotEmpty
    @Pattern(regexp = "^([0-9]{9}|[0-9]{12})$",
            message = "Vui lòng nhập lại theo đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9)")
    private String employeeIdCard;

    @NotNull
    @Min(1)
    private Integer employeeSalary;

    @NotEmpty
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$",
            message = "Vui lòng nhập lại theo định dạng : 090xxxxxxx hoặc 091xxxxxxx " +
                    "hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx (x là số 0-9)")
    private String employeePhone;

    @NotBlank
    @Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$",
            message = "Vui lòng nhập lại theo đúng định dạng: abc@gmail.com hoặc abc@gmail.com.vn")
    private String employeeEmail;

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Vui lòng viết hoa chữ cái đầu tiên của mỗi từ!")
    private String employeeAddress;

    private PositionEmpl positionEmpl;
    private EducationDegree educationDegree;
    private Division division;
    private Set<Contract> contract;
}
