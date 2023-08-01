package com.sandee007.restDemo.rest;

import com.sandee007.restDemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class StudentRestController {
    private final String BASE_STRING = "students";
    private List<Student> students;

    @PostConstruct
    public void postConstruct(){
        this.students = new ArrayList<>();

        this.students.add(new Student("s", "1"));
        this.students.add(new Student("s", "2"));
        this.students.add(new Student("s", "3"));
    }

    @PostMapping(BASE_STRING)
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping(BASE_STRING + "/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if(studentId >= students.size() || studentId < 0){
           throw new StudentNotFoundException("Student ID not found: " + studentId);
        }
        return students.get(studentId);
    }

//    add exception handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

//    add another exception handler to catch all types of exceptions
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception e){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
