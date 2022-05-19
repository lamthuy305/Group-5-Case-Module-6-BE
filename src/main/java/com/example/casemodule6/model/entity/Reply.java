package com.example.casemodule6.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reply")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 8192)
    private String text;

    @ManyToOne
    private Comment comment;

    @ManyToOne
    private User user;

    @ManyToOne
    private Profile profile;

    private Date createTime;

    private Long count_like;

    private Long count_dislike;

    public Reply(String text, Comment comment, User user, Profile profile, Date createTime, Long count_like, Long count_dislike) {
        this.text = text;
        this.comment = comment;
        this.user = user;
        this.profile = profile;
        this.createTime = createTime;
        this.count_like= count_like;
        this.count_dislike = count_dislike;
    }
}
