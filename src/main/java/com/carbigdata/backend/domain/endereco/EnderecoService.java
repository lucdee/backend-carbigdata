package com.carbigdata.backend.domain.endereco;

import com.carbigdata.backend.domain.common.NotFoundException;
import com.carbigdata.backend.entity.Endereco;
import com.carbigdata.backend.mapper.EnderecoMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    private final EnderecoRepository repository;
    private final EnderecoMapper mapper;

    public EnderecoService(EnderecoRepository repository, EnderecoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Page<EnderecoDto> list(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    public EnderecoDto find(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new NotFoundException("Endereço não encontrado")));
    }

    public EnderecoDto create(EnderecoDto dto) {
        Endereco endereco = mapper.toEntity(dto);
        endereco.setId(null);
        return mapper.toDto(repository.save(endereco));
    }
}
