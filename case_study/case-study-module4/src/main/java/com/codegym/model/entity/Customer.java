package com.codegym.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String customerCode;
    private String customerName;

    @Column(name = "customer_birthday", columnDefinition = "DATE")
    private String customerBirthday;
    private Integer customerGender;
    private String customerIdCard;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;

    @ManyToOne(targetEntity = CustomerType.class)
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customerTypeId")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer")
    private Set<Contract> contract;

}
