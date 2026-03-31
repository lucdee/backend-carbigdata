package com.carbigdata.backend.service;

import com.carbigdata.backend.dto.request.ClienteRequestDto;
import com.carbigdata.backend.dto.response.ClienteResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteService {
    Page<ClienteResponseDto> list(Pageable pageable);

    ClienteResponseDto find(Long id);

    ClienteResponseDto create(ClienteRequestDto dto);
}
