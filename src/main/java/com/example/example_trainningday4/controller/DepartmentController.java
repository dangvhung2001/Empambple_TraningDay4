package com.example.example_trainningday4.controller;

import com.example.example_trainningday4.dto.DepartmentDto;
import com.example.example_trainningday4.modal.Department;
import com.example.example_trainningday4.service.DepartmanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/api")
@RestController
public class DepartmentController {
    private final DepartmanService departmentService;

    private DepartmentController(DepartmanService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/department")
    public List<Department> findAll() {
        return departmentService.findAll();
    }

    @PostMapping("/createDepartment")
    public ResponseEntity<?> createDepartment(@RequestBody DepartmentDto departmentDto) {
        Department newDepartment = new Department(
                departmentDto.getId(),
                departmentDto.getDescription(),
                departmentDto.getName()
        );
        Department savedDepartment = departmentService.save(newDepartment);
        if (savedDepartment != null) {
            return new ResponseEntity<>(savedDepartment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Faile", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
