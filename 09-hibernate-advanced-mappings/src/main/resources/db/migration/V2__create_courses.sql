CREATE TABLE courses
(
    id            INT AUTO_INCREMENT NOT NULL,
    title         VARCHAR(255) NULL,
    instructor_id INT NULL,
    CONSTRAINT pk_courses PRIMARY KEY (id)
);

ALTER TABLE courses
    ADD CONSTRAINT FK_COURSES_ON_INSTRUCTOR FOREIGN KEY (instructor_id) REFERENCES instructor (id);