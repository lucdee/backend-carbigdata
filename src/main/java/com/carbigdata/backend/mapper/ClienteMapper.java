package com.carbigdata.backend.mapper;

import com.carbigdata.backend.dto.response.ClienteResponseDto;
import com.carbigdata.backend.entity.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteResponseDto toDto(Cliente entity);
    Cliente toEntity(ClienteResponseDto dto);
}
