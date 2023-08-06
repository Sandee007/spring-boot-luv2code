package com.sandee007.hibernateAdvancedMappings;


import com.sandee007.hibernateAdvancedMappings.dao.AppDao;
import com.sandee007.hibernateAdvancedMappings.entity.Instructor;
import com.sandee007.hibernateAdvancedMappings.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateAdvancedMappingsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateAdvancedMappingsApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDao appDao) {
        return runner -> {
//            createInstructor(appDao);
//            findInstructor(appDao);
            deleteInstructor(appDao);
        };
    }

    private void deleteInstructor(AppDao appDao) {
        appDao.deleteInstructorById(2);
    }

    private void findInstructor(AppDao appDao) {
        Instructor instructor = appDao.findInstructorById(1);

        System.out.println(instructor);
        System.out.println(instructor.getInstructorDetail());
    }

    private void createInstructor(AppDao appDao) {
        Instructor instructor = new Instructor("inst", "2", "i@2");
        InstructorDetail instructorDetail = new InstructorDetail("ins 2 Youtube", "luv 2 code");

        instructor.setInstructorDetail(instructorDetail);

        //this will save InstructorDetails as well because CascadeType == ALL
        appDao.save(instructor);
    }
}
