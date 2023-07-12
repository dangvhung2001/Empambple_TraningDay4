package com.example.example_trainningday4.mapper;

import com.example.example_trainningday4.dto.EmployeeDto;
import com.example.example_trainningday4.modal.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Component
public class EmployeeMapper implements EntityMapper<EmployeeDto, Employee>{
    @Override
    public Employee toEntity(EmployeeDto dto) {
        return new Employee(dto.getId(),dto.getName(), dto.getEmail(),dto.getDepartment(),dto.getRole());
    }

    @Override
    public EmployeeDto toDto(Employee entity) {
        return new EmployeeDto(entity.getId(), entity.getName(), entity.getEmail(),entity.getDepartment(),entity.getRole());
    }

    @Override
    public List<Employee> toEntity(List<EmployeeDto> dtoList) {
        List<Employee> entityList = new ArrayList<>();
        for (EmployeeDto dto : dtoList) {
            entityList.add(toEntity(dto));
        }
        return entityList;
    }
    @Override
    public List<EmployeeDto> toDto(List<Employee> entityList) {
        List<EmployeeDto> dtoList = new ArrayList<>();
        for (Employee entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }
}
