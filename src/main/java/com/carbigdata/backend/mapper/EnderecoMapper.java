package com.carbigdata.backend.mapper;

import com.carbigdata.backend.dto.request.EnderecoRequestDto;
import com.carbigdata.backend.dto.response.EnderecoResponseDto;
import com.carbigdata.backend.entity.Endereco;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {
    EnderecoResponseDto toDto(Endereco entity);

    Endereco toEntity(EnderecoRequestDto request);
}
