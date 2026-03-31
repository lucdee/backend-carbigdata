package com.carbigdata.backend.service.impl;

import com.carbigdata.backend.dto.request.EnderecoRequestDto;
import com.carbigdata.backend.dto.response.EnderecoResponseDto;
import com.carbigdata.backend.entity.Endereco;
import com.carbigdata.backend.exception.NotFoundException;
import com.carbigdata.backend.mapper.EnderecoMapper;
import com.carbigdata.backend.repository.EnderecoRepository;
import com.carbigdata.backend.service.EnderecoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EnderecoServiceImpl implements EnderecoService {
    private final EnderecoRepository repository;
    private final EnderecoMapper mapper;

    public EnderecoServiceImpl(EnderecoRepository repository, EnderecoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Page<EnderecoResponseDto> list(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    public EnderecoResponseDto find(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new NotFoundException("Endereço não encontrado")));
    }

    @Override
    public EnderecoResponseDto create(EnderecoRequestDto request) {
        Endereco endereco = mapper.toEntity(request);
        endereco.setId(null);
        return mapper.toDto(repository.save(endereco));
    }
}
