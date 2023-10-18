package com.example.postgres.controller;

import com.example.postgres.Entity.Employee;
import com.example.postgres.Repository.EmployeeRepo;
import com.example.postgres.Request.EmployeeRequest;
import com.example.postgres.Services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/postgres")
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @Autowired
    private EmployeeRepo employeeRepo;
    @GetMapping
    public List<Employee> getAllEmployee(){

        return employeeRepo.findAll();
    }

      @GetMapping("/{id}")
    public Employee getEmployeeId(@PathVariable Long id){
        return employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
      }
      @PostMapping
      public ResponseEntity<Employee> saveEmployee(@RequestBody @Valid EmployeeRequest employeeRequest){
        return new ResponseEntity<>(service.saveEmployee(employeeRequest), HttpStatus.CREATED);
      }
//      public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest){
//        return new Employee(service.).save(employee),HttpStatus.CREATED)
//    }


@PutMapping("/{id}")
public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
    Employee existingEmployee = employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    existingEmployee.setFirstName(updatedEmployee.getFirstName());
    existingEmployee.setLastName(updatedEmployee.getLastName());
    existingEmployee.setEmail(updatedEmployee.getEmail());
    existingEmployee.setGender(updatedEmployee.getGender());
    existingEmployee.setMobile(updatedEmployee.getMobile());

    return employeeRepo.save(existingEmployee);
}
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long id)
        throws ResourceNotFoundException {
            Employee employee = employeeRepo.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));


            employeeRepo.delete(employee);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return response;
        }
    }


