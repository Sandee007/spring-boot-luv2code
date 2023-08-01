package com.sandee007.cruddemo.dao;

import com.sandee007.cruddemo.entity.Student;

import java.util.List;

public interface IGlobalDao<T> {
    void save(T data);
    T findById(Integer id);
    List<T> findAll();
    void update(T data);
    void deleteById(Integer id);
}
