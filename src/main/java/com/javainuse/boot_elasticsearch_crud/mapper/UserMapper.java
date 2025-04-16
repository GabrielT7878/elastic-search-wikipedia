package com.javainuse.boot_elasticsearch_crud.mapper;

import com.javainuse.boot_elasticsearch_crud.controller.request.UserRequest;
import com.javainuse.boot_elasticsearch_crud.controller.response.UserResponse;
import com.javainuse.boot_elasticsearch_crud.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {
    public static User toUser(UserRequest userRequest) {
        return User.builder()
                .username(userRequest.username())
                .email(userRequest.email())
                .password(userRequest.password())
                .build();
    }

    public static UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
