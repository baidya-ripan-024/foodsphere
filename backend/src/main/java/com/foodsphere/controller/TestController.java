package com.foodsphere.controller;

import com.foodsphere.dto.api.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tests")
public class TestController {

    @GetMapping
    public ResponseEntity<ApiResponse<String>> getMessage(){
        var response = new ApiResponse<String>(
                true,
                "Hello World",
                null
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
