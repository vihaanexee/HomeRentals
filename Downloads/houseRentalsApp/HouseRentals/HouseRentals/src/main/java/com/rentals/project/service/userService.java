package com.rentals.project.service;

import com.rentals.project.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class userService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

}
