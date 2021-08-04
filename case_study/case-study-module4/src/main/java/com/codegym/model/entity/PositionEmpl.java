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
public class PositionEmpl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer positionId;
    private String positionName;

    @OneToMany(mappedBy = "positionEmpl")
    private Set<Employee> employees;
}
