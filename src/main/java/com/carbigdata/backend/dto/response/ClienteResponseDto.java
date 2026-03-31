package com.carbigdata.backend.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ClienteResponseDto(Long id, String nome, LocalDate dataNascimento, String cpf, LocalDateTime dataCriacao) {}
