package com.codegym.dto;

import com.codegym.model.entity.contract_detail.ContractDetail;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.service.Service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDto {
    private Integer contractId;

    private String contractStartDate;

//    @FutureOrPresent
    private String contractEndDate;

    @NotNull
    @Positive
    private Integer contractDeposit;

    @NotNull
    @Positive
    private Integer contractTotalMoney;

    private Employee employee;
    private Customer customer;
    private Service service;
    private Set<ContractDetail> contractDetail;
}
