package com.codegym.dto;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.customer.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Integer customerId;

    @NotEmpty
    @Pattern(regexp = "^(KH)-[0-9]{4}$", message = "Vui lòng nhập lại theo định dạng : KH-XXXX (X là số 0-9)")
    private String customerCode;

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Vui lòng viết hoa chữ cái đầu tiên của mỗi từ!")
    private String customerName;

    private String customerBirthday;
    private Integer customerGender;

    @NotEmpty
    @Pattern(regexp = "^([0-9]{9}|[0-9]{12})$",
            message = "Vui lòng nhập lại theo đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9)")
    private String customerIdCard;

    @NotEmpty
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$",
            message = "Vui lòng nhập lại theo định dạng : 090xxxxxxx hoặc 091xxxxxxx " +
                    "hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx (x là số 0-9)")
    private String customerPhone;

    @NotBlank
    @Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$",
            message = "Vui lòng nhập lại theo đúng định dạng: abc@gmail.com hoặc abc@gmail.com.vn")
    private String customerEmail;

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Vui lòng viết hoa chữ cái đầu tiên của mỗi từ!")
    private String customerAddress;

    private CustomerType customerType;
    private Set<Contract> contract;
}
