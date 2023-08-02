package com.sandee007.employeesCrud.dao.employee;

import com.sandee007.employeesCrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao implements IEmployeeDao {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee payload) {
        /*
        * if id == 0 -> insert
        * else -> update
        * */
        return entityManager.merge(payload); // * has the updated id in case of an insert
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(this.findById(id));
    }
}
