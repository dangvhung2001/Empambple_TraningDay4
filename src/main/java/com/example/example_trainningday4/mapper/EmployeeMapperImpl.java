package com.example.example_trainningday4.mapper;

import com.example.example_trainningday4.dto.EmployeeDto;
import com.example.example_trainningday4.modal.Employee;
import com.example.example_trainningday4.modal.Role;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {
    public Employee toEntity(EmployeeDto dto) {
        if (dto==null){
            return null;
        }
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        return employee;
    }

    public EmployeeDto toDto(Employee entity) {
        if (entity==null){
            return null;
        }
        EmployeeDto employeeDTO = new EmployeeDto();
        employeeDTO.setId(entity.getId());
        employeeDTO.setName(entity.getName());
        employeeDTO.setEmail(entity.getEmail());
        employeeDTO.setDepartmentName(entity.getDepartment().getName());
        List<String> listRole = new ArrayList<>();
        for (Role r: entity.getRoles()) {
            listRole.add(r.getName());
        }
        employeeDTO.setRole(listRole);
        return employeeDTO;
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
