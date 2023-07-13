package com.example.example_trainningday4.controller;


import com.example.example_trainningday4.dto.EmployeeDto;
import com.example.example_trainningday4.mapper.EmployeeMapperImpl;
import com.example.example_trainningday4.modal.Department;
import com.example.example_trainningday4.modal.Employee;
import com.example.example_trainningday4.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api")

public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeMapperImpl employeeMapper;

    private EmployeeController(EmployeeService employeeService, EmployeeMapperImpl employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

    @GetMapping("/employee")
    public ResponseEntity<Page<EmployeeDto>> findAll(
            @RequestParam(name = "name", required = false) String name,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable,
            @SortDefault(sort = "id", direction = Sort.Direction.ASC) Sort sort) {
        Page<Employee> employeePage;
        employeePage = (Page<Employee>) employeeService.findByNameIsContaining(name, pageable);
        Page<EmployeeDto> employeeDtoPage = employeePage.map(employeeMapper::toDto);
        return ResponseEntity.ok(employeeDtoPage);
    }

    @PostMapping("/employee")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        boolean existingEmail = employeeService.exitsByEmail(employee.getEmail());
        if (existingEmail) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Email already exists");
        }
        Employee newEmployee = new Employee(
                employee.getId(),
                employee.getEmail(),
                employee.getName(),
                employee.getDepartment(),
                employee.getDepartmentId(),
                employee.getRoles()
        );
        Employee savedDepartment = employeeService.save(newEmployee);
        EmployeeDto employeeDto = employeeMapper.toDto(savedDepartment);
        if (employeeDto != null) {
            return new ResponseEntity<>("success", HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().body("error");
        }
    }

    @PutMapping("/employee")
    public ResponseEntity<?> update(@RequestBody Employee employee) {
        Employee existingEmail = employeeService.findByEmail(employee.getEmail());
        if (existingEmail.getId() != employee.getId()) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Email already exists");
        }
        employeeService.save(employee);
        EmployeeDto employeeDto = employeeMapper.toDto(employee);
        return new ResponseEntity<>("Update success!" + employeeDto, HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        Optional<Employee> employee = Optional.ofNullable(employeeService.findById(id));

        if (employee.isPresent()) {
            employeeService.deleteById(id);
            return new ResponseEntity<>("deleteSuccess", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("deleteFailure", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Employee> employee = Optional.ofNullable(employeeService.findById(id));
        if (employee.isPresent()) {
            employeeService.findById(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
