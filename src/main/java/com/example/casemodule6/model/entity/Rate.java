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

    private Long count_five_star;

    private Long count_four_star;

    private Long count_three_star;

    private Long count_two_star;

    private Long count_one_star;

}
