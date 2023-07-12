package com.example.example_trainningday4.modal;

import javax.persistence.*;

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
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public Employee(Long id, String name, String email, Department department, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public void setDepartment(Department department) {
        this.department = department;
    }
}
