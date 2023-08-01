package com.sandee007.cruddemo.dao.Student;

import com.sandee007.cruddemo.dao.IGlobalDao;
import com.sandee007.cruddemo.entity.Student;

import java.util.List;

public interface IStudentDao extends IGlobalDao<Student> {
    List<Student> findByLastName(String lastName);
    int deleteAll();
}
