package com.codegym.dto;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract_detail.AttachService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDetailDto {
    private Integer contractDetailId;
    private Contract contract;
    private AttachService attachService;

    @NotNull
    @Positive
    private Integer quantity;
}
