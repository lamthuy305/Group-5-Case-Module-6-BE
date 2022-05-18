package com.example.casemodule6.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String numberPhone;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    private boolean isActive;

    public User(String username , String numberPhone, String password,Set<Role> roles, boolean isActive) {
        this.username = username;
        this.numberPhone=numberPhone;
        this.password = password;
        this.roles = roles;
        this.isActive = isActive;
    }

    public User(Long id) {
        this.id = id;
    }
}


