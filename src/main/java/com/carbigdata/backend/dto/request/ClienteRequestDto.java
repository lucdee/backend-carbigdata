package com.carbigdata.backend.dto.request;

import java.time.LocalDate;

public record ClienteRequestDto(String nome, LocalDate dataNascimento, String cpf) {}
