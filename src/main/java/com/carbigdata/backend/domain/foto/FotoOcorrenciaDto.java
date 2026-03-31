package com.carbigdata.backend.domain.foto;

import java.time.LocalDateTime;

public record FotoOcorrenciaDto(Long id, Long ocorrenciaId, LocalDateTime dataCriacao, String pathBucket, String hash) {}
