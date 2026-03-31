package com.carbigdata.backend.domain.ocorrencia;

import com.carbigdata.backend.entity.Cliente;
import com.carbigdata.backend.domain.cliente.ClienteRepository;
import com.carbigdata.backend.domain.common.NotFoundException;
import com.carbigdata.backend.entity.Endereco;
import com.carbigdata.backend.domain.endereco.EnderecoRepository;
import com.carbigdata.backend.entity.Ocorrencia;
import com.carbigdata.backend.mapper.OcorrenciaMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OcorrenciaService {
    private final OcorrenciaRepository repository;
    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;
    private final OcorrenciaMapper mapper;

    public OcorrenciaService(OcorrenciaRepository repository, ClienteRepository clienteRepository, EnderecoRepository enderecoRepository, OcorrenciaMapper mapper) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
        this.mapper = mapper;
    }

    public Page<OcorrenciaDto> list(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    public OcorrenciaDto find(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new NotFoundException("Ocorrência não encontrada")));
    }

    public OcorrenciaDto create(OcorrenciaRequest request) {
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
