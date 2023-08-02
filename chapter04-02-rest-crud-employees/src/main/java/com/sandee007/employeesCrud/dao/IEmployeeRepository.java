package com.sandee007.employeesCrud.dao;

import com.sandee007.employeesCrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "members")
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
}
