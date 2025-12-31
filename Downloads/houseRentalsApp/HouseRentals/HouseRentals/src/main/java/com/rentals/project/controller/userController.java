package com.rentals.project.controller;

import com.rentals.project.dto.UserRegistrationRequest;
import com.rentals.project.dto.UserResponse;
import com.rentals.project.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Generated;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("api/public/register")
    public ResponseEntity<UserResponse> registerUser (@RequestBody UserRegistrationRequest request){
        UserResponse newUser = userService.registerUser((request));
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserInfo(@PathVariable Long id){
        UserResponse user = userService.getUserById((id));
        return ResponseEntity.ok(user);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponse>  getUserByEmail(@PathVariable String email){
        UserResponse user= userService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id")
    public ResponseEntity<UserResponse> updateUserInfo(@PathVariable Long id , @RequestBody UserRegistrationRequest updatedInfo){
        UserResponse user = userService.updateUserInfo(id, updatedInfo);
        return ResponseEntity.ok(user);
    }
}
