package com.sandee007.hibernateAdvancedMappings.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "instructor_detail")
@Getter
@Setter
//@ToString
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    // refers to the instructorDetail attribute in Instructor class
//    @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
//    choose all cascade types except ALL
    @OneToOne(mappedBy = "instructorDetail", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Instructor instructor;

    public InstructorDetail() {
    }

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
//        putting instructor in here will fail, because it is not directly mapped to db table, only hibernate knows it.
//        instructorDetail is a mappedBy property
//        read - https://thorben-janssen.com/lombok-hibernate-how-to-avoid-common-pitfalls/

        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
