package com.sandee007.employeesCrud.rest;

import com.sandee007.employeesCrud.entity.Employee;
import com.sandee007.employeesCrud.service.employee.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeRestController {
    private EmployeeService employeeService;
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
}
