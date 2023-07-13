package com.example.example_trainningday4.dto;

import com.example.example_trainningday4.modal.Department;
import com.example.example_trainningday4.modal.Role;

import java.util.*;
import java.util.Set;

public class EmployeeDto {
    private Long id;
    private String name;
    private String email;
    private Department department;
    private String departmentName;
    private List<String> role;

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, String name, String email, Department department, String departmentName, List<String> role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.departmentName = departmentName;
        this.role = role;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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
}
