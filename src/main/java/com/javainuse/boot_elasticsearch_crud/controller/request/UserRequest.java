package com.javainuse.boot_elasticsearch_crud.controller.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record UserRequest(@Valid @NotNull @NotEmpty
                          String username,
                          @Valid @NotNull @NotEmpty @Email
                          String email,
                          @Valid @NotNull @NotEmpty @Size(min = 5, max = 20)
                          String password) {
}
