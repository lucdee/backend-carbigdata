package com.carbigdata.backend.mapper;

import com.carbigdata.backend.domain.cliente.ClienteDto;
import com.carbigdata.backend.entity.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteDto toDto(Cliente entity);
    Cliente toEntity(ClienteDto dto);
}
