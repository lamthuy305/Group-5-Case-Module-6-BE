package com.example.casemodule6.controller;

import com.example.casemodule6.model.entity.*;
import com.example.casemodule6.service.house.IHouseService;
import com.example.casemodule6.service.notificationdetail.NotificationDetailService;
import com.example.casemodule6.service.profile.IProfileService;
import com.example.casemodule6.service.rate.IRateService;
import com.example.casemodule6.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

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

    @Autowired
    private IProfileService profileService;

    @Autowired
    private NotificationDetailService notificationDetailService;

    @GetMapping("/{houseId}")
    public ResponseEntity<Iterable<Rate>> getAllRatesByHouseId(@PathVariable Long houseId) {
        Iterable<Rate> rates = rateService.findAllByHouseId(houseId);
        if (rates == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rates, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Rate> createNewRate(@RequestBody Rate rate) {
        Optional<Rate> rateOptional = rateService.findRateByUserIdAndHouId(rate.getUser().getId(), rate.getHouse().getId());
        Optional<User> userOptional = userService.findById(rate.getUser().getId());
        String path = "/view/" + rate.getHouse().getId();
        Profile profile = profileService.findByUserId(rate.getUser().getId());
        NotificationDetail notificationDetail = new NotificationDetail(new StatusNotification(3L), rate.getHouse(), new Date(), path, rate.getUser(),profile);
        notificationDetailService.save(notificationDetail);
        if (rateOptional.isPresent()) {
            rateOptional.get().setStar(rate.getStar());
            rateService.save(rateOptional.get());
        } else {
            rateService.save(rate);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{houseId}/average")
    public double showTotalRateByHouseId(@PathVariable Long houseId) {
        double totalRate = Math.round(rateService.showTotalRateByHouseId(houseId));
        return totalRate;
    }

}
