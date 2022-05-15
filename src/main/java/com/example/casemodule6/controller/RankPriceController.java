package com.example.casemodule6.controller;

import com.example.casemodule6.model.entity.RankPrice;
import com.example.casemodule6.service.rankprice.IRankpriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/rankPrice")
public class RankPriceController {

    @Autowired
    IRankpriceService rankpriceService;

    @GetMapping
    public ResponseEntity<Iterable<RankPrice>> getAllRankPrice() {
        Iterable<RankPrice> statusHouses = rankpriceService.findAll();
        return new ResponseEntity<>(statusHouses, HttpStatus.OK);
    }
}
