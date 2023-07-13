package com.example.example_trainningday4.modal;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    private Long departmentId;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "employee_role",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles = new HashSet<>();

    public Employee() {
    }

    public Employee(Long id, String name, String email, Department department, Long departmentId, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.departmentId = departmentId;
        this.roles = roles;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee(String name, String email, Department department, Role role) {
    }

    public Department getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
