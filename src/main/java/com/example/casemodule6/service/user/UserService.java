package com.example.casemodule6.service.user;

import com.example.casemodule6.model.dto.UserPrincipal;
import com.example.casemodule6.model.entity.Role;
import com.example.casemodule6.model.entity.User;
import com.example.casemodule6.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        String password = user.getPassword();
        String encodePassword = passwordEncoder.encode(password);//Mã hóa pass của người dùng
        user.setPassword(encodePassword);
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(2L, "ROLE_USER"));
        user.setRoles(roles);
        return userRepository.save(user);
    }

    @Override
    public void removeById(Long id) {

    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return UserPrincipal.build(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Iterable<User> findAllUser() {
        return userRepository.checkUser();
    }

    @Override
    public boolean checkRegexPassword(String password) {
        String regex = "^(?=.*)(?=.*).{6,8}$"; // mật khẩu từ 6-8 ký tự
        return Pattern.matches(regex, password);
    }
}
