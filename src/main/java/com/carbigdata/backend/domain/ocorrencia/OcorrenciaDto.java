package com.carbigdata.backend.domain.ocorrencia;

import com.carbigdata.backend.entity.StatusOcorrencia;
import java.time.LocalDateTime;

public record OcorrenciaDto(Long id, Long clienteId, Long enderecoId, LocalDateTime dataOcorrencia, StatusOcorrencia status) {}
