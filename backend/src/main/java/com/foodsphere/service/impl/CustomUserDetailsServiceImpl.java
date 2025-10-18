package com.foodsphere.service.impl;

import com.foodsphere.enums.Role;
import com.foodsphere.model.User;
import com.foodsphere.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || username.isBlank()) {
            throw new UsernameNotFoundException("Username cannot be null or empty");
        }

        String email = username.trim().toLowerCase();
        log.info("Loading user by email {}", email);

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        return buildUserDetails(
                user.getEmail(),
                user.getPassword(),
                user.getRole() != null ? user.getRole() : Role.ROLE_CUSTOMER
        );
    }

    // helper method to build user details
    private UserDetails buildUserDetails(String email, String password, Role role) {
        GrantedAuthority authority = new SimpleGrantedAuthority(role.name());
        return org.springframework.security.core.userdetails.User
                .withUsername(email)
                .password(password)
                .authorities(Collections.singletonList(authority))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}