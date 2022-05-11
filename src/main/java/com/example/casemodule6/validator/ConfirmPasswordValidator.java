package com.example.casemodule6.validator;

import com.example.casemodule6.model.dto.PasswordForm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConfirmPasswordValidator implements ConstraintValidator<PasswordConfirm, PasswordForm> {

    @Override
    public boolean isValid(PasswordForm passwordForm, ConstraintValidatorContext context) {
        if(passwordForm.getPassword().equals(passwordForm.getConfirmPassword())){
            return true;
        }
        return false;
    }
}
