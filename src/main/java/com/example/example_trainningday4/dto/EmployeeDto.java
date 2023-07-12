package com.example.example_trainningday4.dto;

import com.example.example_trainningday4.modal.Department;
import com.example.example_trainningday4.modal.Role;

public class EmployeeDto {
    private Long id;
    private String name;
    private String email;
    private Department department;
    private Role role;

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, String name, String email, Department department, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
