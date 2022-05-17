package com.example.casemodule6.model.dto;

import com.example.casemodule6.model.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseForm {
    private Long id;

    private String name;

    private double area;

    @ManyToOne
    private City city;

    private String location;

    private String description;

    private int bedroom;

    private int bathroom;

    private double price;

    private MultipartFile img;

    private List<MultipartFile> images;

    @OneToOne
    private StatusHouse statusHouse;

    @OneToOne
    private Type type;

    @ManyToOne
    private User user;

}
