package com.example.casemodule6.model.dto;

import com.example.casemodule6.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
public class ProfileForm {

    private String name;

    private String birthday;

    private MultipartFile avatar;

    private String email;

    private String address;

    private String phone;

    private User user;
}
