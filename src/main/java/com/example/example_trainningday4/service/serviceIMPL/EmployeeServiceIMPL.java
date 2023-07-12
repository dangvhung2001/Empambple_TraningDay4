package com.example.example_trainningday4.service.serviceIMPL;

import com.example.example_trainningday4.dto.DepartmentDto;
import com.example.example_trainningday4.dto.EmployeeDto;
import com.example.example_trainningday4.modal.Department;
import com.example.example_trainningday4.modal.Employee;
import com.example.example_trainningday4.repository.EmployeeRepository;
import com.example.example_trainningday4.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeServiceIMPL implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee update(Long id, Employee employee) {
        return null;
    }

    @Override
    public Page<Employee> findAllEmployee(Pageable pageable, Sort sort) {
        pageable = PageRequest.of(pageable.getPageNumber(), 3,sort);
        return employeeRepository.findAll(pageable);
    }

    @Override
    public EmployeeDto convertToDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getDepartment(),
                employee.getRole());
        return employeeDto;
    }

    @Override
    public Employee convertToEtity(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getName(),
                employeeDto.getEmail(),
                employeeDto.getDepartment(),
                employeeDto.getRole());
        return employee;
    }

    @Override
    public List<EmployeeDto> convertToDtoList(List<Employee> employeeList) {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        for (Employee employee : employeeList) {
            EmployeeDto employeeDto = convertToDto(employee);
            employeeDtoList.add(employeeDto);
        }
        return employeeDtoList;
    }

    @Override
    public List<Employee> convertToList(List<EmployeeDto> employeeDtoList) {
        List<Employee> employeeList = new ArrayList<>();
        for (EmployeeDto employeeDto : employeeDtoList) {
            Employee employee = convertToEtity(employeeDto);
            employeeList.add(employee);
        }
        return employeeList;
    }

    @Override
    public boolean exitsByEmail(String email) {
        return employeeRepository.existsByEmail(email);
    }

//    @Override
//    public Iterable<Employee> findEmployeeByName(Pageable pageable,String name) {
//        pageable = PageRequest.of(pageable.getPageNumber(), 3);
//        return employeeRepository.findEmployeeByName(pageable,name);
//    }

}
