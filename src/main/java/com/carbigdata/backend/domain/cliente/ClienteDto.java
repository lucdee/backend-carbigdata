package com.carbigdata.backend.domain.cliente;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ClienteDto(Long id, String nome, LocalDate dataNascimento, String cpf, LocalDateTime dataCriacao) {}
