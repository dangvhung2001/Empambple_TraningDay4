package com.example.example_trainningday4.service;

import com.example.example_trainningday4.dto.DepartmentDto;
import com.example.example_trainningday4.modal.Department;

import java.util.*;

public interface IDepartmanService extends IGeneric<Department,Long>{
    DepartmentDto convertToDto(Department department);
    Department convertToEtity(DepartmentDto departmentDto);
    List<DepartmentDto> convertToDtoList(List<Department> departmentList);
    List<Department> convertToList(List<DepartmentDto> departmentDtos);
}
