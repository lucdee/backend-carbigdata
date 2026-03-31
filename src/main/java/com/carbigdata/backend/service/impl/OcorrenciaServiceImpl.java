package com.carbigdata.backend.service.impl;

import com.carbigdata.backend.dto.request.OcorrenciaRequestDto;
import com.carbigdata.backend.dto.response.OcorrenciaResponseDto;
import com.carbigdata.backend.entity.Cliente;
import com.carbigdata.backend.entity.Endereco;
import com.carbigdata.backend.entity.Ocorrencia;
import com.carbigdata.backend.exception.NotFoundException;
import com.carbigdata.backend.mapper.OcorrenciaMapper;
import com.carbigdata.backend.reposdory.ClienteRepository;
import com.carbigdata.backend.reposdory.EnderecoRepository;
import com.carbigdata.backend.reposdory.OcorrenciaRepository;
import com.carbigdata.backend.service.OcorrenciaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OcorrenciaServiceImpl implements OcorrenciaService {
    private final OcorrenciaRepository repository;
    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;
    private final OcorrenciaMapper mapper;

    public OcorrenciaServiceImpl(OcorrenciaRepository repository, ClienteRepository clienteRepository, EnderecoRepository enderecoRepository, OcorrenciaMapper mapper) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
        this.mapper = mapper;
    }

    @Override
    public Page<OcorrenciaResponseDto> list(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    public OcorrenciaResponseDto find(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new NotFoundException("Ocorrência não encontrada")));
    }

    @Override
    public OcorrenciaResponseDto create(OcorrenciaRequestDto request) {
        Cliente cliente = clienteRepository.findById(request.clienteId()).orElseThrow(() -> new NotFoundException("Cliente não encontrado"));
        Endereco endereco = enderecoRepository.findById(request.enderecoId()).orElseThrow(() -> new NotFoundException("Endereço não encontrado"));
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setCliente(cliente);
        ocorrencia.setEndereco(endereco);
        ocorrencia.setDataOcorrencia(request.dataOcorrencia());
        ocorrencia.setStatus(request.status());
        return mapper.toDto(repository.save(ocorrencia));
    }
}
