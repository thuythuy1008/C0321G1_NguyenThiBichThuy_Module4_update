package com.codegym.dto;

import com.codegym.model.entity.contract_detail.ContractDetail;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.service.Service;
import lombok.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDto implements Validator {
    private Integer contractId;

    private String contractStartDate;

    private String contractEndDate;

    @NotNull
    @Positive
    private Integer contractDeposit;

    @Positive
    private Integer contractTotalMoney;

    private Employee employee;
    private Customer customer;
    private Service service;
    private Set<ContractDetail> contractDetail;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @SneakyThrows
    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        String stringStartDate = contractDto.getContractStartDate();

        if (stringStartDate.equals("")) {
            errors.rejectValue("contractStartDate", "contractStartDate.notBlank");
            return;
        }

        Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(stringStartDate);
        String stringEndDate = contractDto.getContractEndDate();

        if (stringEndDate.equals("")) {
            errors.rejectValue("contractEndDate", "contractEndDate.notBlank");
            return;
        }

        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(stringEndDate);
        java.sql.Date dateNow = new java.sql.Date(System.currentTimeMillis());

        if (startDate.compareTo(dateNow) < 0) {
            errors.rejectValue("contractStartDate", "contractStartDate.pastDay");
        }

        if (startDate.compareTo(endDate) > 0 || startDate.compareTo(endDate) == 0) {
            errors.rejectValue("contractEndDate", "contractEndDate.day");
        }
    }
}
