package com.carbigdata.backend.domain.cliente;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteDto toDto(Cliente entity);
    Cliente toEntity(ClienteDto dto);
}
