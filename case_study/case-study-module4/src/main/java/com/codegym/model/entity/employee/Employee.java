package com.codegym.model.entity.employee;

import com.codegym.model.entity.contract.Contract;
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
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String employeeName;

    @Column(name = "employee_birthday", columnDefinition = "DATE")
    private String employeeBirthday;
    private String employeeIdCard;
    private Integer employeeSalary;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;

    @ManyToOne(targetEntity = PositionEmpl.class)
    @JoinColumn(name = "position_id", referencedColumnName = "positionId")
    private PositionEmpl positionEmpl;

    @ManyToOne(targetEntity = EducationDegree.class)
    @JoinColumn(name = "education_degree_id", referencedColumnName = "educationDegreeId")
    private EducationDegree educationDegree;

    @ManyToOne(targetEntity = Division.class)
    @JoinColumn(name = "division_id", referencedColumnName = "divisionId")
    private Division division;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Contract> contract;
}