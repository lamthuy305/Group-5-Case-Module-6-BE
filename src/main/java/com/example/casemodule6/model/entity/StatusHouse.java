package com.example.casemodule6.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "status_house")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
