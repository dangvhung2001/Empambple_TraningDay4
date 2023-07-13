package com.example.example_trainningday4.service.serviceimpl;

import com.example.example_trainningday4.dto.EmployeeDto;
import com.example.example_trainningday4.modal.Employee;
import com.example.example_trainningday4.modal.Role;
import com.example.example_trainningday4.repository.EmployeeRepository;
import com.example.example_trainningday4.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeServiceIMPL implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    private EmployeeServiceIMPL(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee update(Long id, Employee employee) {
        return null;
    }

    @Override
    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email).get();
    }

    @Override
    public Pageable findByNameIsContaining(String name, Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), 5, Sort.by("name"));
        return employeeRepository.findByNameIsContaining(name, pageable);
    }

    @Override
    public Page<Employee> findAllEmployee(Pageable pageable, Sort sort) {
        pageable = PageRequest.of(pageable.getPageNumber(), 3, sort);
        return employeeRepository.findAll(pageable);
    }

    @Override
    public boolean exitsByEmail(String email) {
        return employeeRepository.existsByEmail(email);
    }

}
