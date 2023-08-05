package com.luv2code.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


//    spring jpa will automagically sort the findAll() method my reading the below naming pattern
    public List<Employee> findAllByOrderByLastNameDesc();
}
