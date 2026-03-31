package com.carbigdata.backend.domain.foto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/ocorrencias/{ocorrenciaId}/fotos")
public class FotoOcorrenciaController {
    private final FotoOcorrenciaService service;

    public FotoOcorrenciaController(FotoOcorrenciaService service) { this.service = service; }

    @GetMapping
    public Page<FotoOcorrenciaDto> list(@PathVariable Long ocorrenciaId, Pageable pageable) {
        return service.listByOcorrencia(ocorrenciaId, pageable);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public FotoOcorrenciaDto upload(@PathVariable Long ocorrenciaId, @RequestPart("file") MultipartFile file) {
        return service.upload(ocorrenciaId, file);
    }
}
