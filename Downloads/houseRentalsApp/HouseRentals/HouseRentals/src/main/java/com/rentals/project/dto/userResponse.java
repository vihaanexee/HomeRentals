package com.rentals.project.dto;

import com.rentals.project.entity.userRole;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class userResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNo;
    private userRole role;
    private Boolean active;
    private LocalDateTime createdAt;

}
