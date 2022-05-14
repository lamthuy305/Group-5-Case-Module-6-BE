package com.example.casemodule6.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "rank_bathroom")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RankBathroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public RankBathroom(Long id) {
        this.id = id;
    }
}
