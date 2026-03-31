package com.carbigdata.backend.dto.response;

import java.time.LocalDateTime;

public record FotoOcorrenciaResponseDto(Long id, Long ocorrenciaId, LocalDateTime dataCriacao, String pathBucket, String hash) {}
