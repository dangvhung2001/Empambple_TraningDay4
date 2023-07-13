package com.example.example_trainningday4.service;

import com.example.example_trainningday4.dto.EmployeeDto;
import com.example.example_trainningday4.modal.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface EmployeeService {
    Page<Employee> findAllEmployee(Pageable pageable, Sort sort);

    boolean exitsByEmail(String email);

    List<Employee> findAll();

    Employee save(Employee employee);

    void deleteById(Long id);

    Employee findById(Long id);

    Employee update(Long id, Employee employee);

    Employee findByEmail(String email);

    Pageable findByNameIsContaining(String name, Pageable pageable);
}
