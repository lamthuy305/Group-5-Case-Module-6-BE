package com.example.casemodule6.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 8192)
    private String text;

    @ManyToOne
    private User user;

    @ManyToOne
    private House house;

    @ManyToOne
    private Profile profile;

    private Date createTime;

    private Long count_like;

    private Long count_dislike;


    public Comment(String text, User user, House house, Profile profile, Date createTime, Long count_like, Long count_dislike) {
        this.text = text;
        this.user = user;
        this.house = house;
        this.profile = profile;
        this.createTime = createTime;
        this.count_like = count_like;
        this.count_dislike = count_dislike;
    }
}