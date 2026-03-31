package com.carbigdata.backend.domain.ocorrencia;

import com.carbigdata.backend.entity.StatusOcorrencia;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record OcorrenciaRequest(
        @NotNull Long clienteId,
        @NotNull Long enderecoId,
        @NotNull LocalDateTime dataOcorrencia,
        @NotNull StatusOcorrencia status
) {}
