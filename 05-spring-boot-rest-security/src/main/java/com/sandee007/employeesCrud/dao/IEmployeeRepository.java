package com.sandee007.employeesCrud.dao;

import com.sandee007.employeesCrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
}
