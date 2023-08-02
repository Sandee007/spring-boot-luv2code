package com.sandee007.employeesCrud.service.employee;

import com.sandee007.employeesCrud.dao.employee.EmployeeDao;
import com.sandee007.employeesCrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee payload) {
        return employeeDao.save(payload);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        employeeDao.deleteById(id);
    }
}
