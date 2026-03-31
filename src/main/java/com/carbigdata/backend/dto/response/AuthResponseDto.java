package com.carbigdata.backend.dto.response;

public record AuthResponseDto(String token, long expiresInSeconds) {}
