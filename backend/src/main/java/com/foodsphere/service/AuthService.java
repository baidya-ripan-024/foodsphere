package com.foodsphere.service;

import com.foodsphere.dto.api.ApiResponse;
import com.foodsphere.dto.auth.LoginRequest;
import com.foodsphere.dto.auth.LoginResponse;
import com.foodsphere.dto.auth.SignupRequest;
import com.foodsphere.dto.auth.SignupResponse;

public interface AuthService {

    ApiResponse<SignupResponse> signup(SignupRequest request);

    ApiResponse<LoginResponse> login(LoginRequest request);
}
