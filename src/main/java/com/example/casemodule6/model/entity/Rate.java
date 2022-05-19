package com.example.casemodule6.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "rates")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int star;

    @OneToOne
    private User user;

    @ManyToOne
    private House house;

    public Rate(int star, User user, House house) {
        this.star = star;
        this.user = user;
        this.house = house;
    }
}
