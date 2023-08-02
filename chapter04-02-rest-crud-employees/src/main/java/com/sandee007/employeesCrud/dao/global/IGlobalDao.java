package com.sandee007.employeesCrud.dao.global;

import java.util.List;

public interface IGlobalDao<T> {
    List<T> findAll();
    T findById(int id);
    T save(T payload);
    void deleteById(int id);
}
