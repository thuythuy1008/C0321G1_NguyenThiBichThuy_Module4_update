package com.codegym.model.entity.security;

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
public class AppUser {
    @Id
    private String userName;
    private String userPassword;

    @ManyToMany
    @JoinTable (name = "user_role",
    joinColumns = @JoinColumn(name = "user_name"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<AppRole> appRoles;

    @OneToOne(mappedBy = "appUser")
    private Employee employee;
}
