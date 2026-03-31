package com.carbigdata.backend.service;

import com.carbigdata.backend.dto.response.FotoOcorrenciaResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface FotoOcorrenciaService {
    Page<FotoOcorrenciaResponseDto> listByOcorrencia(Long ocorrenciaId, Pageable pageable);

  /*  FotoOcorrenciaResponseDto upload(Long ocorrenciaId, MultipartFile file);*/
}
