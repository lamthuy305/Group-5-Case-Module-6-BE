package com.example.casemodule6.service.user;

import com.example.casemodule6.model.entity.User;
import com.example.casemodule6.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends IGeneralService<User>, UserDetailsService {

    User findByUsername(String username);

    Iterable<User> findAllUser();

    boolean checkRegexPassword(String password);
}
