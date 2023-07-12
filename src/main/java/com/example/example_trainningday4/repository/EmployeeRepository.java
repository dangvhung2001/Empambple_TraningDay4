package com.example.example_trainningday4.repository;

import com.example.example_trainningday4.modal.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
//    @Query("Select b from Employee  as b where b.name like concat('%',:name,'%')")
//    Iterable<Employee> findEmployeeByName(Pageable pageable, @Param("name") String name);
    boolean existsByEmail(String email);
}
