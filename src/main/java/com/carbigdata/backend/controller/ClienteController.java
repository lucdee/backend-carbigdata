package com.carbigdata.backend.controller;

import com.carbigdata.backend.dto.response.ClienteResponseDto;
import com.carbigdata.backend.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public Page<ClienteResponseDto> list(Pageable pageable) {
        return service.list(pageable);
    }

    @GetMapping("/{id}")
    public ClienteResponseDto get(@PathVariable Long id) {
        return service.find(id);
    }

    @PostMapping
    public ClienteResponseDto create(@RequestBody @Valid ClienteResponseDto dto) {
        return service.create(dto);
    }
}
