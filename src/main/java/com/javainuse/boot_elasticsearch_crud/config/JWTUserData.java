package com.javainuse.boot_elasticsearch_crud.config;

import lombok.Builder;

@Builder
public record JWTUserData(Long userId, String email) {
}

