package com.example.employeeManager.service;

import com.example.employeeManager.Exceptions.UserNotFoundException;
import com.example.employeeManager.model.Employee;
import com.example.employeeManager.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
     EmployeeRepo employeeRepo;

    public Employee addEmployee(Employee employee){
        //auto generating employeeCode
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployee(){
        return  employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public  Employee findEmployeeById(Long id) throws UserNotFoundException {
        return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User by id "+ id + " was not found"));
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);

    }
}
