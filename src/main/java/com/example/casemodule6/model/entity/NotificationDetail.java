package com.example.casemodule6.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "notification_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private StatusNotification statusNotification;

    @OneToOne
    private House house;

    public NotificationDetail(StatusNotification statusNotification, House house) {
        this.statusNotification = statusNotification;
        this.house = house;
    }
}
