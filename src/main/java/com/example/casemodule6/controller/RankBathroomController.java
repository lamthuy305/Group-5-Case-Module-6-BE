package com.example.casemodule6.controller;

import com.example.casemodule6.model.entity.RankBathroom;
import com.example.casemodule6.service.rankbathroom.IRankbathroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/rankBathroom")
public class RankBathroomController {

    @Autowired
    IRankbathroomService rankbathroomService;

    @GetMapping
    public ResponseEntity<Iterable<RankBathroom>> getAllStatusHouse() {
        Iterable<RankBathroom> statusHouses = rankbathroomService.findAll();
        return new ResponseEntity<>(statusHouses, HttpStatus.OK);
    }
}
