package com.rentals.project.dto;

import com.rentals.project.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;
    private UserRole role;
    private Boolean active;
    private LocalDateTime createdAt;

}
