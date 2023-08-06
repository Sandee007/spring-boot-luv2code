package com.sandee007.hibernateAdvancedMappings.dao;

import com.sandee007.hibernateAdvancedMappings.entity.Instructor;
import com.sandee007.hibernateAdvancedMappings.entity.InstructorDetail;

public interface AppDao {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
