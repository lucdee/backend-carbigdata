package com.carbigdata.backend.domain.cliente;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService service) { this.service = service; }

    @GetMapping
    public Page<ClienteDto> list(Pageable pageable) { return service.list(pageable); }

    @GetMapping("/{id}")
    public ClienteDto get(@PathVariable Long id) { return service.find(id); }

    @PostMapping
    public ClienteDto create(@RequestBody @Valid ClienteDto dto) { return service.create(dto); }
}
