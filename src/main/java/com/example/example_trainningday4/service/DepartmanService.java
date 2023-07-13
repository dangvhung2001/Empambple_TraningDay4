package com.example.example_trainningday4.service;

import com.example.example_trainningday4.dto.DepartmentDto;
import com.example.example_trainningday4.modal.Department;

import java.util.*;

public interface DepartmanService {
    List<Department> findAll();

    Department save(Department department);

    void deleteById(Long id);

    Department findById(Long id);

    Department update(Long id, Department department);
}
