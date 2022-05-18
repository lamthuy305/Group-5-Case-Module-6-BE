package com.example.casemodule6.controller;

import com.example.casemodule6.model.entity.Rate;
import com.example.casemodule6.service.house.IHouseService;
import com.example.casemodule6.service.rate.IRateService;
import com.example.casemodule6.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/rates")
public class RatingController {
    @Autowired
    private IRateService rateService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IHouseService houseService;

    @GetMapping("/{houseId}")
    public ResponseEntity<Iterable<Rate>> getAllRatesByHouseId(@PathVariable Long houseId){
        Iterable<Rate> rates = rateService.findAllByHouseId(houseId);
        if(rates == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rates,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Rate> createNewRate(@RequestBody Rate rate){
        return new ResponseEntity<>(rateService.save(rate),HttpStatus.CREATED);
    }

    @GetMapping("/{houseId}/average")
   public double showTotalRateByHouseId(@PathVariable Long houseId){
        double totalRate = Math.round(rateService.showTotalRateByHouseId(houseId));
        return totalRate;
    }

}
