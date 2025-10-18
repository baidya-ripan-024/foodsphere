package com.foodsphere.service.impl;

import com.foodsphere.security.JwtProvider;
import com.foodsphere.model.User;
import com.foodsphere.repository.UserRepository;
import com.foodsphere.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * This class is the implementation of the UserService interface.
 * This class is implementing the findUserByJwt and findUserByEmail methods.
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    @Override
    public User findUserByJwt(String jwt) throws Exception {
        String email = jwtProvider.getEmailFromToken(jwt);

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("User not found with email: " + email));
    }

    @Override
    public User findUserByEmail(String email) throws Exception {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("User not found with email: " + email));
    }

}