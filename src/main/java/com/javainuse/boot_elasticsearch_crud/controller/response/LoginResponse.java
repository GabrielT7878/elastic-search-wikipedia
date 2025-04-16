package com.javainuse.boot_elasticsearch_crud.controller.response;

import lombok.Builder;

@Builder
public record LoginResponse(String id, String username, String email, String role, String token) {
}
