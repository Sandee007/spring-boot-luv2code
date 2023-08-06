CREATE TABLE courses_students
(
    course_id  INT NOT NULL,
    student_id INT NOT NULL
);

CREATE TABLE students
(
    id         INT AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(255) NULL,
    last_name  VARCHAR(255) NULL,
    email      VARCHAR(255) NULL,
    CONSTRAINT pk_students PRIMARY KEY (id)
);

ALTER TABLE courses_students
    ADD CONSTRAINT fk_coustu_on_course FOREIGN KEY (course_id) REFERENCES courses (id);

ALTER TABLE courses_students
    ADD CONSTRAINT fk_coustu_on_student FOREIGN KEY (student_id) REFERENCES students (id);