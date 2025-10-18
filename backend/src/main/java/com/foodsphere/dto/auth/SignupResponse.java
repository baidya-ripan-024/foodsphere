package com.foodsphere.dto.auth;

import com.foodsphere.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupResponse {
    private String token;
    private String fullName;
    private String email;
    private Role role;
}
