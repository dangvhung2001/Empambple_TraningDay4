package com.example.example_trainningday4.service.serviceimpl;

import com.example.example_trainningday4.dto.DepartmentDto;
import com.example.example_trainningday4.modal.Department;
import com.example.example_trainningday4.repository.DepartmentRepository;
import com.example.example_trainningday4.service.DepartmanService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceIMPL implements DepartmanService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceIMPL(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department findById(Long id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public Department update(Long id, Department department) {
        return null;
    }
}
