package com.carbigdata.backend.controller;

import com.carbigdata.backend.domain.endereco.EnderecoDto;
import com.carbigdata.backend.domain.endereco.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {
    private final EnderecoService service;

    public EnderecoController(EnderecoService service) { this.service = service; }

    @GetMapping
    public Page<EnderecoDto> list(Pageable pageable) { return service.list(pageable); }

    @GetMapping("/{id}")
    public EnderecoDto get(@PathVariable Long id) { return service.find(id); }

    @PostMapping
    public EnderecoDto create(@RequestBody @Valid EnderecoDto dto) { return service.create(dto); }
}
