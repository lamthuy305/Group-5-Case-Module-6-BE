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

    @Column(columnDefinition = "LONGTEXT")
    private String description;

    private String img;

    public House(String name, double area, String location, int bedroom, int bathroom, double price, String description, String img, Long count_rent, StatusHouse statusHouse, Type type, User user) {
        this.name = name;
        this.area = area;
        this.location = location;
        this.bedroom = bedroom;
        this.bathroom = bathroom;
        this.price = price;
        this.description = description;
        this.img = img;
        this.count_rent = count_rent;
        this.statusHouse = statusHouse;
        this.type = type;
        this.user = user;
    }

    private Long count_rent;

    @OneToOne
    private StatusHouse statusHouse;

    @OneToOne
    private Type type;

    @ManyToOne
    private User user;




}
