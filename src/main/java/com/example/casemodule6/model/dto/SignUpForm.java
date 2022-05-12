package com.example.casemodule6.model.dto;

import com.example.casemodule6.model.entity.Role;
import com.example.casemodule6.validator.PasswordConfirm;
import com.example.casemodule6.validator.UniqueUsername;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpForm {
    @NotEmpty
    @UniqueUsername
    private String username;

    @NotEmpty
    private String numberPhone;

    @PasswordConfirm
    private PasswordForm passwordForm;

    private Set<Role> roles;
}
