package com.sandee007.hibernateAdvancedMappings.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="reviews")
@Getter
@Setter
@ToString
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "comment")
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY) // * default is EAGER
    @JoinColumn(name = "course_id")
    private Course course;

    public Review(){}

    public Review(String comment) {
        this.comment = comment;
    }
}
