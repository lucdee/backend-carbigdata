package com.carbigdata.backend.mapper;

import com.carbigdata.backend.domain.endereco.EnderecoDto;
import com.carbigdata.backend.entity.Endereco;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {
    EnderecoDto toDto(Endereco entity);
    Endereco toEntity(EnderecoDto dto);
}
