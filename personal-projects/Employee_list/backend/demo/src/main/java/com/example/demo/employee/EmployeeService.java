package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/* - - Repository -> Service layer (Business logic) - - */
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void addNewEmployee(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository
                .findEmployeeByEmail(employee.getEmailId());

        if (employeeOptional.isPresent()) {
            throw new IllegalStateException("Email taken!");
        }
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long Id) {
        boolean exists = employeeRepository.existsById(Id);
        if (!exists) {
            throw new IllegalStateException("Employee with id " + Id + " does not exist");
        }

        employeeRepository.deleteById(Id);
    }

    @Transactional
    public void updateEmployee(Long Id,
                               String firstName,
                               String lastName,
                               String emailId) {
        Employee employee = employeeRepository.findById(Id)
                .orElseThrow(() -> new IllegalStateException(
                        "Employee with id " + Id + " does not exist!"));

        if (firstName != null &&
                firstName.length() > 0 &&
                !Objects.equals(employee.getFirstName(), firstName)) {
            employee.setFirstName(firstName);
        }

        if (lastName != null &&
                lastName.length() > 0 &&
                !Objects.equals(employee.getLastName(), lastName)) {
            employee.setFirstName(lastName);
        }

        if (emailId != null &&
                emailId.length() > 0 &&
                !Objects.equals(employee.getEmailId(), emailId)) {
            Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(emailId);
            if (employeeOptional.isPresent()) {
                throw new IllegalStateException("Email taken!");
            }
            employee.setEmailId(emailId);
        }


    }
}
