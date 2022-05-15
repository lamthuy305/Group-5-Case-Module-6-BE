package com.example.casemodule6.controller;

import com.example.casemodule6.model.entity.RankBedroom;
import com.example.casemodule6.service.rankbedroom.IRankbedroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/rankBedroom")
public class RankBedroomController {

    @Autowired
    IRankbedroomService rankbedroomService;

    @GetMapping
    public ResponseEntity<Iterable<RankBedroom>> getAllStatusHouse() {
        Iterable<RankBedroom> statusHouses = rankbedroomService.findAll();
        return new ResponseEntity<>(statusHouses, HttpStatus.OK);
    }
}
