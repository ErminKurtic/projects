package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Get -  to get/show all or specified info from database
    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();

    }

    // Post - Used for inserting to database
    @PostMapping
    public void registerNewEmployee(@RequestBody Employee employee) {
        employeeService.addNewEmployee(employee);
    }

    // Delete - For deleting object from database
    @DeleteMapping(path = "{Id}")
    public void deleteEmployee(@PathVariable("Id") Long Id) {
        employeeService.deleteEmployee(Id);
    }

    // Put - Edit/Change current object inside database
    @PutMapping(path = "{Id}")
    public void updateEmployee(
            @PathVariable("Id") Long Id,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String emailId) {
        employeeService.updateEmployee(Id, firstName, lastName, emailId);
    }
}
