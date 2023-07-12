package com.example.example_trainningday4.controller;


import com.example.example_trainningday4.dto.EmployeeDto;
import com.example.example_trainningday4.modal.Department;
import com.example.example_trainningday4.modal.Employee;
import com.example.example_trainningday4.modal.Role;
import com.example.example_trainningday4.service.IDepartmanService;
import com.example.example_trainningday4.service.IEmployeeService;
import com.example.example_trainningday4.service.IRoleService;
import com.example.example_trainningday4.service.serviceIMPL.EmployeeServiceIMPL;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api")

public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IDepartmanService departmanService;
    @Autowired
    private IRoleService roleService;

    @GetMapping("/employee")
    public ResponseEntity<?> findAll(Pageable pageable) {
        Page<Employee> employee = employeeService.findAllEmployee(pageable);
        if (employee.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(employee.getContent());
    }

    @PostMapping("/employee")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        boolean existingEmail = employeeService.exitsByEmail(employee.getEmail());
        if (existingEmail) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Email already exists");
        }
        employeeService.save(employee);
        EmployeeDto employeeDto = employeeService.convertToDto(employee);
        if (employeeDto != null) {
            return new ResponseEntity<>("success", HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().body("error");
        }
    }

    @PutMapping("/employee")
    public ResponseEntity<?> update(@RequestBody EmployeeDto employeeDto) {
        boolean existingEmail = employeeService.exitsByEmail(employeeDto.getEmail());
        if (existingEmail) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Email already exists");
        }
            return new ResponseEntity<>("Update success!", HttpStatus.OK);
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
