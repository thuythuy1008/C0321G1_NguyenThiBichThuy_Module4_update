package com.codegym.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractDetailId;

    @ManyToOne(targetEntity = Contract.class)
    @JoinColumn(name = "contract_id", referencedColumnName = "contractId")
    private Contract contract;

    @ManyToOne(targetEntity = AttachService.class)
    @JoinColumn(name = "attach_service_id", referencedColumnName = "attachServiceId")
    private AttachService attachService;

    private Integer quantity;
}
