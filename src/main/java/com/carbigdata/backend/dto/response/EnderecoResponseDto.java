package com.carbigdata.backend.dto.response;

public record EnderecoResponseDto(Long id, String logradouro, String bairro, String cep, String cidade, String estado) {}
