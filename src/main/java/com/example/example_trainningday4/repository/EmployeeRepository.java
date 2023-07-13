package com.example.example_trainningday4.repository;

import com.example.example_trainningday4.modal.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsByEmail(String email);

    Pageable findByNameIsContaining(String name, Pageable pageable);

    Optional<Employee> findByEmail(String email);
}
