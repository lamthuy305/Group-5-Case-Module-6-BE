package com.example.casemodule6.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordForm {
    @NotEmpty
    @Size(min = 6, max = 15)
    private String password;

    @NotEmpty
    @Size(min = 6, max = 15)
    private String confirmPassword;
}
