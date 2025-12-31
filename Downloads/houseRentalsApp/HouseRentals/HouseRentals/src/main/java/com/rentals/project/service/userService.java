package com.rentals.project.service;

import com.rentals.project.entity.User;
import com.rentals.project.Repository.UserRepository;
import com.rentals.project.dto.UserRegistrationRequest;
import com.rentals.project.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponse convertToResponse(User user){
        return new UserResponse(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhoneNo(),
                user.getRole(),
                user.getActive(),
                user.getCreatedAt()
        );
    }

    public UserResponse registerUser(UserRegistrationRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered:" + request.getEmail());
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPhoneNo(request.getPhoneNo());

        User savedUser = userRepository.save(user);
        return convertToResponse(savedUser);
    }
    public UserResponse getUserById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(("User not found with id: " + id)));
        return convertToResponse(user);
    }
    public UserResponse getUserByEmail(String email){
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException(("email not found: " ) + email ));
        return convertToResponse(user);
    }

    public UserResponse updateUserInfo(Long id , UserRegistrationRequest updateInfo){
        User userExists = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("this userExists does not exist check id :" + id));

        userExists.setFirstName((updateInfo.getFirstName()));
        userExists.setLastName((updateInfo.getLastName()));
        userExists.setPhoneNo(updateInfo.getPhoneNo());

        if(updateInfo.getPassword() != null && updateInfo.getPassword().isEmpty()){
            userExists.setPassword(passwordEncoder.encode(updateInfo.getPassword()));
        }
        User savedUser = userRepository.save(userExists);
        return convertToResponse(savedUser);
    }
    }

