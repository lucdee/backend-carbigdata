package com.carbigdata.backend.service;

import com.carbigdata.backend.dto.request.EnderecoRequestDto;
import com.carbigdata.backend.dto.response.EnderecoResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EnderecoService {
    Page<EnderecoResponseDto> list(Pageable pageable);

    EnderecoResponseDto find(Long id);

    EnderecoResponseDto create(EnderecoRequestDto request);
}
