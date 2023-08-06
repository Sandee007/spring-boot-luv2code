package com.sandee007.hibernateAdvancedMappings.dao;

import com.sandee007.hibernateAdvancedMappings.entity.Instructor;
import com.sandee007.hibernateAdvancedMappings.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        entityManager.remove(this.findInstructorById(id));
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
}
