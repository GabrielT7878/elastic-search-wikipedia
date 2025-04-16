package com.javainuse.boot_elasticsearch_crud.controller;

import com.javainuse.boot_elasticsearch_crud.controller.request.LoginRequest;
import com.javainuse.boot_elasticsearch_crud.controller.request.UserRequest;
import com.javainuse.boot_elasticsearch_crud.controller.response.LoginResponse;
import com.javainuse.boot_elasticsearch_crud.controller.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthController {

    @Operation(summary = "Register a User", description = "Register a User")
    @PostMapping("/register")
    ResponseEntity<UserResponse> register(@RequestBody @Valid UserRequest userRequest);

    @Operation(summary = "Login", description = "Login with credentials : email and password")
    @PostMapping("/login")
    ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest);
}
