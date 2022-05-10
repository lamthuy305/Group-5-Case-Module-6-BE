package com.example.casemodule6.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "houses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double area;

    private String location;

    private int bedroom;

    private int bathroom;

    private double price;

    private String image;

    private Long count_rent;

    @OneToOne
    private StatusHouse statusHouse;

    @OneToOne
    private Type type;

    @ManyToOne
    private User user;
}
