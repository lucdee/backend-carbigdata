package com.carbigdata.backend.domain.endereco;

public record EnderecoDto(Long id, String logradouro, String bairro, String cep, String cidade, String estado) {}
