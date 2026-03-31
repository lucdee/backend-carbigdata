package com.carbigdata.backend.dto.response;

import com.carbigdata.backend.entity.StatusOcorrencia;
import java.time.LocalDateTime;

public record OcorrenciaResponseDto(Long id, Long clienteId, Long enderecoId, LocalDateTime dataOcorrencia, StatusOcorrencia status) {}
