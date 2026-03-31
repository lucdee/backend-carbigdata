package com.carbigdata.backend.mapper;

import com.carbigdata.backend.entity.FotoOcorrencia;
import com.carbigdata.backend.dto.response.FotoOcorrenciaResponseDto;
import com.carbigdata.backend.dto.response.OcorrenciaResponseDto;
import com.carbigdata.backend.entity.Ocorrencia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OcorrenciaMapper {

    @Mapping(target = "clienteId", source = "cliente.id")
    @Mapping(target = "enderecoId", source = "endereco.id")
    OcorrenciaResponseDto toDto(Ocorrencia entity);

    @Mapping(target = "ocorrenciaId", source = "ocorrencia.id")
    FotoOcorrenciaResponseDto toDto(FotoOcorrencia foto);
}
