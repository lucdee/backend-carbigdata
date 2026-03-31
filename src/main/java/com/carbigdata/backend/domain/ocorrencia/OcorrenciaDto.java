package com.carbigdata.backend.domain.ocorrencia;

import java.time.LocalDateTime;

public record OcorrenciaDto(Long id, Long clienteId, Long enderecoId, LocalDateTime dataOcorrencia, StatusOcorrencia status) {}
