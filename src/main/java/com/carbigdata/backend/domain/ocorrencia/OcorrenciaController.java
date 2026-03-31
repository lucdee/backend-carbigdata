package com.carbigdata.backend.domain.ocorrencia;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ocorrencias")
public class OcorrenciaController {
    private final OcorrenciaService service;

    public OcorrenciaController(OcorrenciaService service) { this.service = service; }

    @GetMapping
    public Page<OcorrenciaDto> list(Pageable pageable) { return service.list(pageable); }

    @GetMapping("/{id}")
    public OcorrenciaDto get(@PathVariable Long id) { return service.find(id); }

    @PostMapping
    public OcorrenciaDto create(@RequestBody @Valid OcorrenciaRequest request) { return service.create(request); }
}
