CREATE TABLE instructor
(
    id                   INT AUTO_INCREMENT NOT NULL,
    first_name           VARCHAR(255) NULL,
    last_name            VARCHAR(255) NULL,
    email                VARCHAR(255) NULL,
    instructor_detail_id INT NULL,
    CONSTRAINT pk_instructor PRIMARY KEY (id)
);

CREATE TABLE instructor_detail
(
    id              INT AUTO_INCREMENT NOT NULL,
    youtube_channel VARCHAR(255) NULL,
    hobby           VARCHAR(255) NULL,
    CONSTRAINT pk_instructor_detail PRIMARY KEY (id)
);

ALTER TABLE instructor
    ADD CONSTRAINT FK_INSTRUCTOR_ON_INSTRUCTOR_DETAIL FOREIGN KEY (instructor_detail_id) REFERENCES instructor_detail (id);