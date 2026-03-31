package com.carbigdata.backend.domain.endereco;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {
    EnderecoDto toDto(Endereco entity);
    Endereco toEntity(EnderecoDto dto);
}
