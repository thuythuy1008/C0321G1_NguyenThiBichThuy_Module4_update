package com.codegym.model.entity.employee;

import com.codegym.model.entity.employee.Employee;
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
public class PositionEmpl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer positionId;
    private String positionName;

    @OneToMany(mappedBy = "positionEmpl", cascade = CascadeType.ALL)
    private Set<Employee> employees;
}
