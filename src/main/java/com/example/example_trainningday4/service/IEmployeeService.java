package com.example.example_trainningday4.service;

import com.example.example_trainningday4.dto.DepartmentDto;
import com.example.example_trainningday4.dto.EmployeeDto;
import com.example.example_trainningday4.modal.Department;
import com.example.example_trainningday4.modal.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService extends IGeneric<Employee,Long>{
    Page<Employee> findAllEmployee(Pageable pageable);
//    Iterable<Employee> findEmployeeByName(Pageable pageable, String name);
    EmployeeDto convertToDto(Employee employee);
    Employee convertToEtity(EmployeeDto employeeDto);
    List<EmployeeDto> convertToDtoList(List<Employee> employeeList);
    List<Employee> convertToList(List<EmployeeDto> employeeDtoList);
    boolean exitsByEmail(String email);
}
