package com.example.casemodule6.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "dislike_comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DislikeComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Comment comments;

    @OneToOne
    private User user;

    public DislikeComment(Comment comments, User user) {
        this.comments = comments;
        this.user = user;
    }
}