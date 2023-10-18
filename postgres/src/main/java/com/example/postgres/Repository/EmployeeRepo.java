package com.example.postgres.Repository;

import com.example.postgres.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

Employee findByEmployeeId(long id);
}
