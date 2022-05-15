package com.example.casemodule6.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "rank_bedroom")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RankBedroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public RankBedroom(Long id) {
        this.id = id;
    }
}