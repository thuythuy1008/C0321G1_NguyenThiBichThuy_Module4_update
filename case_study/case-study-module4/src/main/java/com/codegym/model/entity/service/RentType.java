package com.codegym.model.entity.service;

import com.codegym.model.entity.service.Service;
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
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rentTypeId;
    private String rentTypeName;
    private Integer rentTypeCost;

    @OneToMany(mappedBy = "rentType", cascade = CascadeType.ALL)
    private Set<Service> service;
}
