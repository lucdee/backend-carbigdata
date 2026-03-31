package com.carbigdata.backend.dto.request;

import com.carbigdata.backend.validation.Cpf;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record ClienteRequestDto(
        @NotBlank(message = "nome é obrigatório") String nome,
        @NotNull(message = "dataNascimento é obrigatório") LocalDate dataNascimento,
        @NotBlank(message = "cpf é obrigatório") @Cpf String cpf
) {
}
