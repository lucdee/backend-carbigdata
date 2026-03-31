package com.carbigdata.backend.dto.request;

import com.carbigdata.backend.entity.StatusOcorrencia;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record OcorrenciaRequestDto(
        @NotNull Long clienteId,
        @NotNull Long enderecoId,
        @NotNull LocalDateTime dataOcorrencia,
        @NotNull StatusOcorrencia status
) {}
