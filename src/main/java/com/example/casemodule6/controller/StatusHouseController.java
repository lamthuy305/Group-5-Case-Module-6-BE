package com.example.casemodule6.controller;

import com.example.casemodule6.model.entity.StatusHouse;
import com.example.casemodule6.service.statusHouse.IStatusHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/statusHouses")
public class StatusHouseController {

    @Autowired
    IStatusHouseService statusHouseService;

    @GetMapping
    public ResponseEntity<Iterable<StatusHouse>> getAllStatusHouse(){
        Iterable<StatusHouse> statusHouses = statusHouseService.findAll();
        return new ResponseEntity<>(statusHouses, HttpStatus.OK);
    }
}
