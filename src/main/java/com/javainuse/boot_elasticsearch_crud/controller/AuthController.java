package com.javainuse.boot_elasticsearch_crud.controller;

import com.javainuse.boot_elasticsearch_crud.controller.request.LoginRequest;
import com.javainuse.boot_elasticsearch_crud.controller.request.UserRequest;
import com.javainuse.boot_elasticsearch_crud.controller.response.LoginResponse;
import com.javainuse.boot_elasticsearch_crud.controller.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface AuthController {

    @Operation(summary = "Register a User", description = "Register a User")
    @ApiResponse(responseCode = "201", description = "Created a User Sucess",
            content = @Content(schema = @Schema(implementation = UserResponse.class)))
    @ApiResponse(responseCode = "400", description = "Bad Request - Email, Password or Username Invalid Criteria",
            content = @Content())
    @PostMapping("/register")
    ResponseEntity<UserResponse> register(@RequestBody @Valid UserRequest userRequest);

    @Operation(summary = "Login", description = "Login with credentials : email and password")
    @ApiResponse(responseCode = "200", description = "Login Sucess",
            content = @Content(schema = @Schema(implementation = LoginResponse.class)))
    @ApiResponse(responseCode = "400", description = "Bad Request - Email or Password Invalid",
            content = @Content())
    @PostMapping("/login")
    ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest);
}
