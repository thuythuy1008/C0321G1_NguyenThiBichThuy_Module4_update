package com.codegym.dto;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.service.RentType;
import com.codegym.model.entity.service.ServiceType;
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
public class ServiceDto {
    private Integer serviceId;

    @NotEmpty
    @Pattern(regexp = "^(DV)-[0-9]{4}$", message = "Vui lòng nhập lại theo định dạng : DV-XXXX (X là số 0-9)")
    private String serviceCode;

    @NotEmpty
    @Pattern(regexp = "^([A-Z][a-z0-9]*[\\s]?)+$", message = "Vui lòng viết hoa chữ cái đầu tiên của mỗi từ!")
    private String serviceName;

    @NotNull
    @Min(20)
    private Integer serviceArea;

    @NotNull
    @Positive
    private Integer serviceCost;

    @NotNull
    @Positive
    private Integer serviceMaxPeople;

    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Ll}]|[\\p{Ll}][\\p{Ll}]{1,10})){0,5}$",
            message = "Vui lòng viết hoa chữ cái đầu tiên của từ đầu tiên!")
    private String standardRoom;

    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Ll}]|[\\p{Ll}][\\p{Ll}]{1,10})){0,5}$",
            message = "Vui lòng viết hoa chữ cái đầu tiên của từ đầu tiên!")
    private String descriptionOtherConvenience;

    @Min(20)
    private Integer poolArea;

    @Positive
    private Integer numberOfFloors;

    private ServiceType serviceType;
    private RentType rentType;
    private Set<Contract> contract;
}
