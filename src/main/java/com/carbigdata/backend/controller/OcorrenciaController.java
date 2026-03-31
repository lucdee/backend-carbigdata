package com.carbigdata.backend.controller;

import com.carbigdata.backend.dto.request.OcorrenciaRequestDto;
import com.carbigdata.backend.dto.response.OcorrenciaResponseDto;
import com.carbigdata.backend.service.OcorrenciaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ocorrencias")
public class OcorrenciaController {
    private final OcorrenciaService service;

    public OcorrenciaController(OcorrenciaService service) {
        this.service = service;
    }

    @GetMapping
    public Page<OcorrenciaResponseDto> list(Pageable pageable) {
        return service.list(pageable);
    }

    @GetMapping("/{id}")
    public OcorrenciaResponseDto get(@PathVariable Long id) {
        return service.find(id);
    }

    @PostMapping
    public OcorrenciaResponseDto create(@RequestBody @Valid OcorrenciaRequestDto request) {
        return service.create(request);
    }
}
