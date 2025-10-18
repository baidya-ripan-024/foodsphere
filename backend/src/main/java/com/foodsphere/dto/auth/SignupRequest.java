package com.foodsphere.dto.auth;

import com.foodsphere.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    private String fullName;
    private String email;
    private String password;
    private Role role;
}
