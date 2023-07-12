package com.example.example_trainningday4.controller;

import com.example.example_trainningday4.dto.DepartmentDto;
import com.example.example_trainningday4.modal.Department;
import com.example.example_trainningday4.service.IDepartmanService;
import com.example.example_trainningday4.service.serviceIMPL.DepartmentServiceIMPL;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/api")
@RestController
public class DepartmentController {
    @Autowired
    private DepartmentServiceIMPL departmentServiceIMPL;
    @Autowired
    private IDepartmanService departmentService;

    @GetMapping("/department")
    public List<Department> findAll() {
        return departmentServiceIMPL.findAll();
    }

    @PostMapping("/createDepartment")
    public ResponseEntity<?> createDepartment(@RequestBody DepartmentDto departmentDto) {
        Department newDepartment = new Department(
                departmentDto.getId(),
                departmentDto.getDescription(),
                departmentDto.getName()
        );
        Department savedDepartment = departmentService.save(newDepartment);
        if(savedDepartment != null) {
            return new ResponseEntity<>(savedDepartment, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Faile", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
