package com.sandee007.hibernateAdvancedMappings;


import com.sandee007.hibernateAdvancedMappings.dao.AppDao;
import com.sandee007.hibernateAdvancedMappings.entity.Course;
import com.sandee007.hibernateAdvancedMappings.entity.Instructor;
import com.sandee007.hibernateAdvancedMappings.entity.InstructorDetail;
import com.sandee007.hibernateAdvancedMappings.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateAdvancedMappingsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateAdvancedMappingsApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDao appDao) {
        return runner -> {
            //            createInstructor(appDao); // * watch out cuz this return a value now
            //            findInstructor(appDao);
            //            deleteInstructor(appDao);
            //            findInstructorDetailById(appDao);
            //            deleteInstructorDetailById(appDao);
            //            createInstructorWithCourses(appDao);
            //            findInstructorWithCourses(appDao);
            //            findCoursesForInstructor(appDao);
            //            findInstructorWithCoursesJoinFetch(appDao);
            //            updateInstructor(appDao);
            //            updateCourse(appDao);
            //            deleteCourseById(appDao);
            //            createCourseAndReviews(appDao);
            //            findCourseAndReviews(appDao);
            deleteCourseAndReviews(appDao);
        };
    }

    private void deleteCourseAndReviews(AppDao appDao) {
        //        will also delete reviews cuz cascadeType == ALL
        appDao.deleteCourseById(3);
    }

    private void findCourseAndReviews(AppDao appDao) {
        Course course = appDao.findCourseAndReviewsByCourseId(3);
        System.out.println(course);
        System.out.println(course.getReviews());
    }

    private void createCourseAndReviews(AppDao appDao) {
        Course course = new Course("cose");

        course.addReview(new Review("noice cose"));
        course.addReview(new Review("noice noice"));

        appDao.saveCourse(course);
    }

    private void deleteCourseById(AppDao appDao) {
        appDao.deleteCourseById(1);
    }

    private void updateCourse(AppDao appDao) {
        Course course = appDao.findCourseById(1);
        if (course != null) {
            course.setTitle("Lil thangs");
            appDao.updateCourse(course);
        }
    }

    private void updateInstructor(AppDao appDao) {
        Instructor instructor = appDao.findInstructorById(4);
        if (instructor != null) {
            instructor.setLastName("Barby");
            appDao.updateInstructor(instructor);
        }
    }

    private void findInstructorWithCoursesJoinFetch(AppDao appDao) {
        Instructor instructor = appDao.findInstructorByIdJoinFetch(7);
        System.out.println(instructor);

        //        has to manually print the courses cuz there are @ToString.Excluded
        System.out.println(instructor.getCourses());
    }

    private void findCoursesForInstructor(AppDao appDao) {
        List<Course> courses = appDao.findCoursesByInstructorId(7);
        System.out.println(courses);
    }

    private void findInstructorWithCourses(AppDao appDao) {
        Instructor instructor = appDao.findInstructorById(7);

        System.out.println(instructor);
        System.out.println(instructor.getCourses());
    }

    private void createInstructorWithCourses(AppDao appDao) {
        Instructor instructor = new Instructor("course inst", "1", "ci@1");
        InstructorDetail instructorDetail = new InstructorDetail("course tube", "making courses");
        instructor.setInstructorDetail(instructorDetail);

        Course c1 = new Course("Air guitar guide");
        Course c2 = new Course("Pinball masterclass");

        instructor.addCourse(c1);
        instructor.addCourse(c2);

        //        all 3 tables will be saved, cuz cascadeType == persist is set
        appDao.saveInstructor(instructor);
    }

    private void deleteInstructorDetailById(AppDao appDao) {
        appDao.deleteInstructorDetailById(4);
    }

    private void findInstructorDetailById(AppDao appDao) {
        InstructorDetail instructorDetail = appDao.findInstructorDetailById(1);
        System.out.println(instructorDetail);
        System.out.println(instructorDetail.getInstructor());
    }

    private void deleteInstructor(AppDao appDao) {
        appDao.deleteInstructorById(7);
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
        appDao.saveInstructor(instructor);

    }
}
