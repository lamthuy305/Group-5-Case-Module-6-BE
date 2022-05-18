package com.example.casemodule6.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "profile")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String birthday;

    private String avatar;

    private String email;

    private String address;

    private String phone;

    @OneToOne
    private User user;

    public Profile(String avatar, String phone, User user) {
        this.avatar = avatar;
        this.phone = phone;
        this.user = user;
    }
}
