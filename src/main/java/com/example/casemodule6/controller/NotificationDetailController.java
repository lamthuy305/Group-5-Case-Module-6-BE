package com.example.casemodule6.controller;

import com.example.casemodule6.model.entity.InfomationSave;
import com.example.casemodule6.model.entity.NotificationDetail;
import com.example.casemodule6.service.infomationsave.IInfomationSaveService;
import com.example.casemodule6.service.notificationdetail.INotificationDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/notificationDetail")
public class NotificationDetailController {
    @Autowired
    private INotificationDetailService notificationDetailService;

    @Autowired
    IInfomationSaveService infomationSaveService;

    @GetMapping("/{id}")
    public ResponseEntity<Iterable<NotificationDetail>> getAllNotificationDetailByIdUser(@PathVariable Long id) {
        Iterable<NotificationDetail> notificationDetails = notificationDetailService.getAllNotificationDetailByIdUser(id);
        return new ResponseEntity<>(notificationDetails, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Iterable<NotificationDetail>> deleteAllNotificationDetailByIdUser(@PathVariable Long id) {
        Iterable<NotificationDetail> notificationDetails = notificationDetailService.getAllNotificationDetailByIdUser(id);
        for (NotificationDetail notification : notificationDetails) {
            InfomationSave infomationSave = new InfomationSave(notification.getStatusNotification(), notification.getHouse(), notification.getCreateDay(), notification.getPath(), notification.getUser(), notification.getProfile(), false);
            infomationSaveService.save(infomationSave);
            notificationDetailService.removeById(notification.getId());
        }
        return new ResponseEntity<>(notificationDetails, HttpStatus.OK);
    }

}
