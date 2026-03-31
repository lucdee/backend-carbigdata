package com.carbigdata.backend.service.impl;

import com.carbigdata.backend.dto.response.FotoOcorrenciaResponseDto;
import com.carbigdata.backend.entity.FotoOcorrencia;
import com.carbigdata.backend.entity.Ocorrencia;
import com.carbigdata.backend.exception.NotFoundException;
import com.carbigdata.backend.mapper.OcorrenciaMapper;
import com.carbigdata.backend.repository.FotoOcorrenciaRepository;
import com.carbigdata.backend.repository.OcorrenciaRepository;
import com.carbigdata.backend.service.FotoOcorrenciaService;
import java.io.IOException;
import java.time.Instant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FotoOcorrenciaServiceImpl implements FotoOcorrenciaService {
    private final FotoOcorrenciaRepository repository;
    private final OcorrenciaRepository ocorrenciaRepository;
    private final OcorrenciaMapper mapper;
/*    private final ObjectStoragePort storage;*/

    public FotoOcorrenciaServiceImpl(FotoOcorrenciaRepository repository, OcorrenciaRepository ocorrenciaRepository, OcorrenciaMapper mapper) {
        this.repository = repository;
        this.ocorrenciaRepository = ocorrenciaRepository;
        this.mapper = mapper;
   /*     this.storage = storage;*/
    }

    @Override
    public Page<FotoOcorrenciaResponseDto> listByOcorrencia(Long ocorrenciaId, Pageable pageable) {
        return repository.findByOcorrenciaId(ocorrenciaId, pageable).map(mapper::toDto);
    }

   /* @Override
    public FotoOcorrenciaResponseDto upload(Long ocorrenciaId, MultipartFile file) {
        Ocorrencia ocorrencia = ocorrenciaRepository.findById(ocorrenciaId)
                .orElseThrow(() -> new NotFoundException("Ocorrência não encontrada"));

        String objectName = "ocorrencias/%d/%d-%s".formatted(ocorrenciaId, Instant.now().toEpochMilli(), file.getOriginalFilename());

        try {
            ObjectStoragePort.StoredObject uploaded = storage.upload(objectName, file.getContentType(), file.getInputStream(), file.getSize());
            FotoOcorrencia foto = new FotoOcorrencia();
            foto.setOcorrencia(ocorrencia);
            foto.setPathBucket(uploaded.path());
            foto.setHash(uploaded.hash());
            return mapper.toDto(repository.save(foto));
        } catch (IOException e) {
            throw new IllegalStateException("Falha ao ler arquivo recebido", e);
        }
    }*/
}
