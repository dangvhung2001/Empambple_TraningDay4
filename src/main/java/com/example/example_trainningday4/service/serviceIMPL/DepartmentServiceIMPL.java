package com.example.example_trainningday4.service.serviceIMPL;

import com.example.example_trainningday4.dto.DepartmentDto;
import com.example.example_trainningday4.modal.Department;
import com.example.example_trainningday4.repository.DepartmentRepository;
import com.example.example_trainningday4.service.IDepartmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DepartmentServiceIMPL implements IDepartmanService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department save(Department department) {
        DepartmentDto departmentDto = convertToDto(department);

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

    @Override
    public DepartmentDto convertToDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDescription(),
                department.getName()
        );
        return departmentDto;
    }

    @Override
    public Department convertToEtity(DepartmentDto departmentDto) {
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDescription(),
                departmentDto.getName()
        );
        return department;
    }

    @Override
    public List<DepartmentDto> convertToDtoList(List<Department> departmentList) {
        List<DepartmentDto> departmentDtos = new ArrayList<>();
        for (Department department : departmentList) {
            DepartmentDto departmentDto = convertToDto(department);
            departmentDtos.add(departmentDto);
        }
        return departmentDtos;
    }

    @Override
    public List<Department> convertToList(List<DepartmentDto> departmentDtos) {
        List<Department> departments = new ArrayList<>();
        for (DepartmentDto departmentDto : departmentDtos) {
            Department department = convertToEtity(departmentDto);
            departments.add(department);
        }
        return departments;
    }
}
