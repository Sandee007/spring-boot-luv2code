package com.sandee007.employeesCrud.rest;

import com.sandee007.employeesCrud.entity.Employee;
import com.sandee007.employeesCrud.service.employee.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeRestController {
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{employeeId}")
    public Employee findById(@PathVariable int employeeId) throws Exception {
        try {
            return employeeService.findById(employeeId);
        } catch (Exception e) {
            throw new Exception("Employee not found. ID: " + employeeId);
        }
    }

    @PostMapping("")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0); // * because we are using JPA merge
        return employeeService.save(employee);
    }

    @PutMapping("")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/{employeeId}")
    public String deleteById(@PathVariable int employeeId) throws Exception {
        try {
            employeeService.deleteById(employeeId);
            return "Employee Deleted.";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
