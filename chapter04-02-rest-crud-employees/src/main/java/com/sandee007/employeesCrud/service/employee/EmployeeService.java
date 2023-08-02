package com.sandee007.employeesCrud.service.employee;

import com.sandee007.employeesCrud.dao.IEmployeeRepository;
import com.sandee007.employeesCrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    private IEmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);

        Employee employee = null;
        if(result.isPresent()){
            employee = result.get();
        }else{
            throw new RuntimeException("Not found");
        }
        return employee;
    }

    @Override
    public Employee save(Employee payload) {
        return employeeRepository.save(payload);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
