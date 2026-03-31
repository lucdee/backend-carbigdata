package com.carbigdata.backend.domain.cliente;

import com.carbigdata.backend.domain.common.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public ClienteService(ClienteRepository repository, ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Page<ClienteDto> list(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    public ClienteDto find(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new NotFoundException("Cliente não encontrado")));
    }

    public ClienteDto create(ClienteDto dto) {
        Cliente cliente = mapper.toEntity(dto);
        cliente.setId(null);
        return mapper.toDto(repository.save(cliente));
    }
}
