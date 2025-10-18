package com.foodsphere.service.impl;

import com.foodsphere.dto.api.ApiResponse;
import com.foodsphere.dto.auth.LoginRequest;
import com.foodsphere.dto.auth.LoginResponse;
import com.foodsphere.dto.auth.SignupRequest;
import com.foodsphere.dto.auth.SignupResponse;
import com.foodsphere.model.Cart;
import com.foodsphere.model.User;
import com.foodsphere.repository.CartRepository;
import com.foodsphere.repository.UserRepository;
import com.foodsphere.security.JwtProvider;
import com.foodsphere.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Override
    @Transactional
    public ApiResponse<SignupResponse> signup(SignupRequest request) {
        if (request == null || request.getEmail() == null || request.getEmail().isEmpty() || 
            request.getFullName() == null || request.getFullName().isEmpty()) {
            return new ApiResponse<>(false, "Full name and email required", null);
        }

        String email = request.getEmail().trim().toLowerCase();

        // checking if user with email already exist
        if (userRepository.findByEmail(email).isPresent()) {
            return new ApiResponse<>(false, "User already registered with this email", null);
        }

        // creating user
        try {
            User newUser = User.builder()
                    .fullName(request.getFullName())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(request.getRole())
                    .build();
            User savedUser = userRepository.save(newUser);
            log.info("User with email {} saved to database", email);

            // creating cart for the user
            Cart newCart = Cart.builder()
                    .customer(savedUser)
                    .build();
            cartRepository.save(newCart);
            log.info("Cart created for user {}", email);

            // authenticate the user and generate jwt token
            Authentication auth = new UsernamePasswordAuthenticationToken(
                    savedUser.getEmail(),
                    request.getPassword(),
                    List.of(new SimpleGrantedAuthority(savedUser.getRole().name()))
            );
            SecurityContextHolder.getContext().setAuthentication(auth);

            // generate jwt token
            String token = jwtProvider.generateToken(auth);

            // build response
            var response = new SignupResponse(
                    token,
                    savedUser.getFullName(),
                    savedUser.getEmail(),
                    savedUser.getRole()
            );

            log.info("user {} created successfully", email);
            return new ApiResponse<>(true, "User Created Successfully!", response);
        } catch (Exception e) {
            return new ApiResponse<>(false, "Error while signing up customer", null);
        }
    }

    @Override
    public ApiResponse<LoginResponse> login(LoginRequest request) {
        // validating request
        if (request == null || request.getEmail() == null || request.getEmail().isEmpty() ||
        request.getPassword() == null || request.getPassword().isEmpty()) {
            return new ApiResponse<>(false, "Email and password are required", null);
        }

        String email = request.getEmail().trim().toLowerCase();
        String password = request.getPassword();

        // find user by email
        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) {
            log.warn("Login failed: User not found with email {}", email);
            return new ApiResponse<>(false, "Invalid email or password", null);
        }

        // verify password
        boolean isPasswordValid = passwordEncoder.matches(password, user.getPassword());
        if (!isPasswordValid) {
            log.warn("Login failed: Incorrect password for email {}", email);
            return new ApiResponse<>(false, "Invalid email or password", null);
        }

        // authenticate the user and generate jwt
        Authentication auth = new UsernamePasswordAuthenticationToken(
                user.getEmail(),
                null,
                List.of(new SimpleGrantedAuthority(user.getRole().name()))
        );
        SecurityContextHolder.getContext().setAuthentication(auth);

        // generate token
        String token = jwtProvider.generateToken(auth);

        // build response
        var loginResponse = new LoginResponse(
                token,
                user.getFullName(),
                user.getEmail(),
                user.getRole()
        );

        log.info("User {} logged in successfully", email);
        return new ApiResponse<>(true, "Login successful", loginResponse);
    }
}
