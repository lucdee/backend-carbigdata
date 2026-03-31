package com.carbigdata.backend.domain.foto;

import com.carbigdata.backend.domain.common.NotFoundException;
import com.carbigdata.backend.domain.ocorrencia.OcorrenciaRepository;
import com.carbigdata.backend.entity.FotoOcorrencia;
import com.carbigdata.backend.entity.Ocorrencia;
import com.carbigdata.backend.mapper.OcorrenciaMapper;
import com.carbigdata.backend.storage.ObjectStoragePort;
import java.io.IOException;
import java.time.Instant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FotoOcorrenciaService {
    private final FotoOcorrenciaRepository repository;
    private final OcorrenciaRepository ocorrenciaRepository;
    private final OcorrenciaMapper mapper;
    private final ObjectStoragePort storage;

    public FotoOcorrenciaService(FotoOcorrenciaRepository repository, OcorrenciaRepository ocorrenciaRepository, OcorrenciaMapper mapper, ObjectStoragePort storage) {
        this.repository = repository;
        this.ocorrenciaRepository = ocorrenciaRepository;
        this.mapper = mapper;
        this.storage = storage;
    }

    public Page<FotoOcorrenciaDto> listByOcorrencia(Long ocorrenciaId, Pageable pageable) {
        return repository.findByOcorrenciaId(ocorrenciaId, pageable).map(mapper::toDto);
    }

    public FotoOcorrenciaDto upload(Long ocorrenciaId, MultipartFile file) {
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
    }
}
