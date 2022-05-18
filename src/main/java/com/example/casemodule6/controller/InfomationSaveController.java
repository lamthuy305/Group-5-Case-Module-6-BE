package com.example.casemodule6.controller;

import com.example.casemodule6.model.entity.InfomationSave;
import com.example.casemodule6.service.infomationsave.IInfomationSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/infomationSave")
public class InfomationSaveController {
    @Autowired
    private IInfomationSaveService infomationSaveService;

    @GetMapping("/active/{id}")
    public ResponseEntity<Iterable<InfomationSave>> get10InformationSaveByIdUserActive(@PathVariable Long id) {
        Iterable<InfomationSave> notificationSaves = infomationSaveService.get10InformationSaveByIdUserActive(id);
        return new ResponseEntity<>(notificationSaves, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Iterable<InfomationSave>> getAllInformationSaveByIdUserIsActive(@PathVariable Long id) {
        Iterable<InfomationSave> notificationSaves = infomationSaveService.getAllInformationSaveByIdUserIsActive(id);
        return new ResponseEntity<>(notificationSaves, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<InfomationSave> changeActiveInfomation(@RequestParam(name = "id") Long id) {
        Optional<InfomationSave> infomationSaveOptional = infomationSaveService.findById(id);
        if (!infomationSaveOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        infomationSaveOptional.get().setActive(true);
        return new ResponseEntity<>(infomationSaveService.save(infomationSaveOptional.get()), HttpStatus.OK);
    }
}
