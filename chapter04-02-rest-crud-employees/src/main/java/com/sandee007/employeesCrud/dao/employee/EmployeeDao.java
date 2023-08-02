package com.sandee007.employeesCrud.dao.employee;

import com.sandee007.employeesCrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao implements  IEmployeeDao{
    private EntityManager entityManager;

    @Autowired
    public EmployeeDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findALl() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        return query.getResultList();
    }
}
