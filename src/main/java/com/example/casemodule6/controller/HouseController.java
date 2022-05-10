package com.example.casemodule6.controller;

import com.example.casemodule6.model.entity.House;
import com.example.casemodule6.service.house.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/houses")
public class HouseController {
    @Autowired
    private IHouseService houseService;

    @GetMapping
    public ResponseEntity<Iterable<House>> findAllHouse() {
        return new ResponseEntity<>(houseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<House> findOne(@PathVariable Long id) {
        Optional<House> houseOptional = houseService.findById(id);
        if (!houseOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(houseOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<House> save(@ModelAttribute House house){
        return new ResponseEntity<>(houseService.save(house), HttpStatus.CREATED);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        houseService.deleteById(id);
    }


    @PostMapping("{id}")
    public ResponseEntity<House> editHouse(@PathVariable Long id, @ModelAttribute House house){
        Optional<House> houseOptional = houseService.findById(id);
        if(!houseOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        house.setId(id) ;
        return new ResponseEntity<House>(houseService.save(house),HttpStatus.OK);
    }
}
