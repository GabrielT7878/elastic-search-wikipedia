package com.javainuse.boot_elasticsearch_crud.controller.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LoginRequest(
        @Valid @NotNull @NotEmpty
        String email,
        @Valid @NotNull @NotEmpty @Size(min = 5, max = 20)
        String password) {
}
