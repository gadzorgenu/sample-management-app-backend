package com.example.employeeManager.repository;

import com.example.employeeManager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    //creating a query method
    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}
