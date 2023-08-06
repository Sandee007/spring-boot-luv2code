CREATE TABLE reviews
(
    id        INT AUTO_INCREMENT NOT NULL,
    comment   VARCHAR(255) NULL,
    course_id INT NULL,
    CONSTRAINT pk_reviews PRIMARY KEY (id)
);

ALTER TABLE reviews
    ADD CONSTRAINT FK_REVIEWS_ON_COURSE FOREIGN KEY (course_id) REFERENCES courses (id);