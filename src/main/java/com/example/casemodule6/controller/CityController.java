package com.example.casemodule6.controller;

import com.example.casemodule6.model.entity.City;
import com.example.casemodule6.service.city.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/cities")
public class CityController {

    @Autowired
    ICityService cityService;

    @GetMapping
    public ResponseEntity<Iterable<City>> getAllCity() {
        Iterable<City> cities = cityService.findAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }
}
