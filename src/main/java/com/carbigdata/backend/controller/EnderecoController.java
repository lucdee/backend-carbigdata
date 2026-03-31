package com.carbigdata.backend.controller;

import com.carbigdata.backend.dto.response.EnderecoResponseDto;
import com.carbigdata.backend.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {
    private final EnderecoService service;

    public EnderecoController(EnderecoService service) {
        this.service = service;
    }

    @GetMapping
    public Page<EnderecoResponseDto> list(Pageable pageable) {
        return service.list(pageable);
    }

    @GetMapping("/{id}")
    public EnderecoResponseDto get(@PathVariable Long id) {
        return service.find(id);
    }

    @PostMapping
    public EnderecoResponseDto create(@RequestBody @Valid EnderecoResponseDto dto) {
        return service.create(dto);
    }
}
