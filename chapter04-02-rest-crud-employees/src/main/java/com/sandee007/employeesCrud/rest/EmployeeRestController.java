package com.sandee007.employeesCrud.rest;

import com.sandee007.employeesCrud.dao.employee.EmployeeDao;
import com.sandee007.employeesCrud.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeRestController {
    private EmployeeDao employeeDao;
    public EmployeeRestController(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }

    @GetMapping("/")
    public List<Employee> findAll(){
        return employeeDao.findALl();
    }
}
