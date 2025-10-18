package com.foodsphere.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * This class is used to store the JWT properties, which are read from the application.properties file
 * Properties, like - header, secretKey, expiration are read from the application.properties file
 */
@Getter @Setter
@Component
@ConfigurationProperties(prefix = "application.security.jwt")
public class JwtProperties {

    // header name, which will be used to store the JWT token
    private String header;

    // The secret key, which will be used to generate the JWT token
    private String secretKey;

    // Jwt Expiration time in milliseconds
    private long expiration;
}