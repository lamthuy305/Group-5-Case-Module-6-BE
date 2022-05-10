package com.example.casemodule6.validator;


import com.example.casemodule6.model.entity.User;
import com.example.casemodule6.repository.IUserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername,String> {
    private IUserRepository userRepository;

    public UniqueUsernameValidator(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        User user = userRepository.findByUsername(email);
        if(user!=null){
            return false;
        }
        return true;
    }
}
