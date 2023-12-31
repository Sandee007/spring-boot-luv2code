package com.sandee007.hibernateAdvancedMappings.dao;

import com.sandee007.hibernateAdvancedMappings.entity.Course;
import com.sandee007.hibernateAdvancedMappings.entity.Instructor;
import com.sandee007.hibernateAdvancedMappings.entity.InstructorDetail;
import com.sandee007.hibernateAdvancedMappings.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDaoImpl implements AppDao {
    //    define entity manager
    private EntityManager entityManager;

    //    inject entity manager via constructor injection
    @Autowired // optional
    public AppDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveInstructor(Instructor instructor) {
        //this will save InstructorDetails as well because CascadeType == ALL
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        //        this will also retrieve instructor-details as well, cuz default behavior of @OneToOne fetch type is eager
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = this.findInstructorById(id);

        //        break association of all courses for the instructor
        List<Course> courses = instructor.getCourses();
        for (Course course : courses) {
            course.setInstructor(null);
        }
        //    cascade will handle the update of both tables
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = this.findInstructorDetailById(id);

        /*
         * remove the associated object reference
         * break the bi-directional link
         * */
        instructorDetail.getInstructor().setInstructorDetail(null);

        //        delete the instructor detail
        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query = entityManager.createQuery("FROM Course WHERE instructor.id = :id", Course.class);

        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        //        i -> instructor here
        //        * JOIN FETCH is similar to EAGER LOADING
        TypedQuery<Instructor> q = entityManager.createQuery(
                " SELECT i FROM Instructor i " +
                        " JOIN FETCH i.courses " +
                        " JOIN FETCH i.instructorDetail " +
                        " WHERE i.id = :id",
                Instructor.class
        );
        q.setParameter("id", id);
        return q.getSingleResult();
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course = this.findCourseById(id);
        if (course != null) {
            entityManager.remove(course);
        }
    }

    @Override
    @Transactional
    public void saveCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int id) {
        TypedQuery<Course> q = entityManager.createQuery(
                "SELECT c FROM  Course c " +
                        " JOIN FETCH c.reviews" +
                        " WHERE c.id = :id "
                , Course.class);

        q.setParameter("id", id);
        return q.getSingleResult();
    }

    @Override
    public Course findCourseWithStudentsByCourseId(int id) {
        TypedQuery<Course> q = entityManager.createQuery(
                " SELECT c FROM Course c " +
                        " JOIN FETCH c.students" +
                        " WHERE c.id = :id "
                , Course.class);

        q.setParameter("id", id);
        return q.getSingleResult();
    }

    @Override
    public Student findStudentWithCoursesByStudentId(int id) {
        TypedQuery<Student> q = entityManager.createQuery(
                " SELECT s FROM Student  s " +
                        " JOIN FETCH s.courses" +
                        " WHERE s.id = :id "
                , Student.class);

        q.setParameter("id", id);

        return q.getSingleResult();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }
}
