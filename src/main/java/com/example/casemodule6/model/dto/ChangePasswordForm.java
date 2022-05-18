package com.example.casemodule6.model.dto;

import com.example.casemodule6.model.entity.Role;
import com.example.casemodule6.validator.PasswordConfirm;
import com.example.casemodule6.validator.UniqueUsername;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordForm {
    private String username;

    private String currentPassword;


    @PasswordConfirm
    private PasswordForm passwordForm;

    private Set<Role> roles;
}
