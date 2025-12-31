package com.rentals.project.dto;

import lombok.Data;

@Data
public class UserRegistrationRequest {
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String password;
}

