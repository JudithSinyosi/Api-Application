package com.example.postgres.Services;

import com.example.postgres.Entity.Employee;
import com.example.postgres.Repository.EmployeeRepo;
import com.example.postgres.Request.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee saveEmployee(EmployeeRequest employeeRequest) {
        Employee employee = Employee.build(0L, employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getEmail(),
                employeeRequest.getGender(),
                employeeRequest.getMobile());
        return employeeRepo.save(employee);
    }
    public List<Employee> getAllEmployee(){
    return employeeRepo.findAll();
    }
    public Employee getEmployeeById(long id){
        return employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("employee not find"));
    }
}


//        Employee existingEmployee = employeeRepo.findById(employee.getId()).orElse(null);
//
//        if (existingEmployee != null) {
//            throw new EmployeeIdExistsException("Employee with ID " + employee.getId() + " already exists.");
//        }
//
//        // If the ID doesn't exist, proceed with saving or updating the employee
//        return employeeRepo.save(employee);
//    }