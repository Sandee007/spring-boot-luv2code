package com.sandee007.employeesCrud.service.employee;

import com.sandee007.employeesCrud.entity.Employee;

import java.util.List;

public interface IEmployeeService  {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
