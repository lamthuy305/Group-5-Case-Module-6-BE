package com.example.casemodule6.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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

    private Date createDay;

    private String path;

    @OneToOne
    private User user;

    @OneToOne
    private Profile profile;

    public NotificationDetail(StatusNotification statusNotification, House house, Date createDay, String path, User user, Profile profile) {
        this.statusNotification = statusNotification;
        this.house = house;
        this.createDay = createDay;
        this.path = path;
        this.user = user;
        this.profile = profile;
    }
}
