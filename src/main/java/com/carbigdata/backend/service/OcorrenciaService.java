package com.carbigdata.backend.service;

import com.carbigdata.backend.dto.request.OcorrenciaRequestDto;
import com.carbigdata.backend.dto.response.OcorrenciaResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OcorrenciaService {
    Page<OcorrenciaResponseDto> list(Pageable pageable);

    OcorrenciaResponseDto find(Long id);

    OcorrenciaResponseDto create(OcorrenciaRequestDto request);
}
