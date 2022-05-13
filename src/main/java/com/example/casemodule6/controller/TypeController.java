package com.example.casemodule6.controller;

import com.example.casemodule6.model.entity.Type;
import com.example.casemodule6.service.type.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/types")
public class TypeController {
    @Autowired
    private ITypeService typeService;

    @GetMapping
    public ResponseEntity<Iterable<Type>> getAllTypes(){
        Iterable<Type> types = typeService.findAll();
        return new ResponseEntity<>(types, HttpStatus.OK);
    }
}
