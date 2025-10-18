package com.foodsphere.controller;

import com.foodsphere.dto.api.ApiResponse;
import com.foodsphere.dto.auth.LoginRequest;
import com.foodsphere.dto.auth.LoginResponse;
import com.foodsphere.dto.auth.SignupRequest;
import com.foodsphere.dto.auth.SignupResponse;
import com.foodsphere.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<SignupResponse>> signup(@RequestBody SignupRequest request){
        log.info("signup request received for email {}", request.getEmail());
        ApiResponse<SignupResponse> response = authService.signup(request);

        return new ResponseEntity<>(response,
                response.getSuccess() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(@RequestBody LoginRequest request){
        log.info("login request received for email {}", request.getEmail());
        ApiResponse<LoginResponse> response = authService.login(request);

        return new ResponseEntity<>(response,
                response.getSuccess() ? HttpStatus.OK : HttpStatus.UNAUTHORIZED);
    }
}