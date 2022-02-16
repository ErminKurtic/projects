package com.example.demo.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* - - Database access layer class - - */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
