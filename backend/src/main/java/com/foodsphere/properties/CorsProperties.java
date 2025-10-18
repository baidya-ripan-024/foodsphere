package com.foodsphere.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter @Setter
@Component
@ConfigurationProperties(prefix = "application.cors")
public class CorsProperties {

    // List of all allowed origins.
    private List<String> allowedOrigins;
}