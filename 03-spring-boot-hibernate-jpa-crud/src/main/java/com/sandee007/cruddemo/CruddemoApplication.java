package com.sandee007.cruddemo;

import com.sandee007.cruddemo.dao.Student.StudentDao;
import com.sandee007.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDao) {
//		lambda expression
        return runner -> {
           createStudent(studentDao);
//            findStudent(studentDao);
//            findAllStudents(studentDao);
//            findByLastName(studentDao);
//            updateStudent(studentDao);
//            deleteById(studentDao);
//            deleteAll(studentDao);
        };
    }

    private void deleteAll(StudentDao studentDao) {
        studentDao.deleteAll();
    }

    private void deleteById(StudentDao studentDao) {
        studentDao.deleteById(2);
    }

    private void updateStudent(StudentDao studentDao) {
        Student student = studentDao.findById(2);
        student.setFirstName("Scooby");
        studentDao.update(student);
    }

    private void findByLastName(StudentDao studentDao) {
        System.out.println(studentDao.findByLastName("one"));
    }

    private void findAllStudents(StudentDao studentDao) {
        List<Student> studentList = studentDao.findAll();

        for (Student student : studentList) {
            System.out.println("Student: " + student);
        }
    }

    private void findStudent(StudentDao studentDao) {
        System.out.println("Student: " + studentDao.findById(1));
    }

    private void createStudent(StudentDao studentDao) {
        Student student = new Student("Spring boot", "student one", "sbs1@com");
        studentDao.save(student);

        System.out.println("Student Saved. ID:" + student.getId());
    }
}
