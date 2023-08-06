package com.sandee007.hibernateAdvancedMappings.dao;

import com.sandee007.hibernateAdvancedMappings.entity.Course;
import com.sandee007.hibernateAdvancedMappings.entity.Instructor;
import com.sandee007.hibernateAdvancedMappings.entity.InstructorDetail;

import java.util.List;

public interface AppDao {
    void saveInstructor(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
    List<Course> findCoursesByInstructorId(int id);
    Instructor findInstructorByIdJoinFetch(int id);
    void updateInstructor(Instructor instructor);
    void updateCourse(Course course);
    Course findCourseById(int id);
}
