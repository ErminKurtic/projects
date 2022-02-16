package com.example.demo.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/* - - Database access layer class - - */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT s FROM Employee s WHERE s.emailId = ?1")
    Optional<Employee> findEmployeeByEmail(String email);
}
