package com.javainuse.boot_elasticsearch_crud.controller;

import com.javainuse.boot_elasticsearch_crud.config.TokenService;
import com.javainuse.boot_elasticsearch_crud.controller.request.LoginRequest;
import com.javainuse.boot_elasticsearch_crud.controller.request.UserRequest;
import com.javainuse.boot_elasticsearch_crud.controller.response.LoginResponse;
import com.javainuse.boot_elasticsearch_crud.controller.response.UserResponse;
import com.javainuse.boot_elasticsearch_crud.exception.UsernameOrPasswordInvalidException;
import com.javainuse.boot_elasticsearch_crud.mapper.UserMapper;
import com.javainuse.boot_elasticsearch_crud.model.User;
import com.javainuse.boot_elasticsearch_crud.service.AuthService;
import com.javainuse.boot_elasticsearch_crud.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wikipedia/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;


    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody @Valid UserRequest userRequest) {

        User user = UserMapper.toUser(userRequest);
        userService.save(user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserMapper.toUserResponse(user));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        try {
            UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password());

            Authentication authenticate = authenticationManager.authenticate(userAndPass);

            User user = (User) authenticate.getPrincipal();

            System.out.println("User Login: " + user);

            return ResponseEntity
                    .ok(LoginResponse.builder()
                            .id(user.getId())
                            .username(user.getUsername())
                            .email(user.getEmail())
                            .role(user.getRole())
                            .token(tokenService.generateToken(user))
                            .build());
        } catch (BadCredentialsException e) {
            throw new UsernameOrPasswordInvalidException("User or Password is Incorrect.");
        }
    }
}
