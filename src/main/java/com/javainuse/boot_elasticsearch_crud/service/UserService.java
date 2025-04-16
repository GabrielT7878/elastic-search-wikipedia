package com.javainuse.boot_elasticsearch_crud.service;

import com.javainuse.boot_elasticsearch_crud.model.User;
import com.javainuse.boot_elasticsearch_crud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User save(User user) {
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        user.setRole("user");
        return userRepository.save(user);
    }

}
