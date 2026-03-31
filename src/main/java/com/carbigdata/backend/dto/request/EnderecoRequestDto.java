package com.carbigdata.backend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record EnderecoRequestDto(
        @NotBlank(message = "logradouro é obrigatório") String logradouro,
        @NotBlank(message = "bairro é obrigatório") String bairro,
        @NotBlank(message = "cep é obrigatório")
        @Pattern(regexp = "\\d{5}-?\\d{3}", message = "cep deve estar no formato 99999-999") String cep,
        @NotBlank(message = "cidade é obrigatório") String cidade,
        @NotBlank(message = "estado é obrigatório")
        @Size(min = 2, max = 2, message = "estado deve ter 2 caracteres") String estado
) {
}
