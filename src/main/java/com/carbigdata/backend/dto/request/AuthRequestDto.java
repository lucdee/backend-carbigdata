package com.carbigdata.backend.dto.request;

import jakarta.validation.constraints.NotBlank;

public record AuthRequestDto(@NotBlank String username, @NotBlank String password) {}
