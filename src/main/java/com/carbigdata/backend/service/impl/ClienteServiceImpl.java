package com.carbigdata.backend.service.impl;

import com.carbigdata.backend.dto.request.ClienteRequestDto;
import com.carbigdata.backend.dto.response.ClienteResponseDto;
import com.carbigdata.backend.entity.Cliente;
import com.carbigdata.backend.exception.NotFoundException;
import com.carbigdata.backend.mapper.ClienteMapper;
import com.carbigdata.backend.repository.ClienteRepository;
import com.carbigdata.backend.service.ClienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public ClienteServiceImpl(ClienteRepository repository, ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Page<ClienteResponseDto> list(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    public ClienteResponseDto find(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new NotFoundException("Cliente não encontrado")));
    }

    @Override
    public ClienteResponseDto create(ClienteRequestDto request) {
        Cliente cliente = mapper.toEntity(request);
        cliente.setId(null);
        return mapper.toDto(repository.save(cliente));
    }
}
